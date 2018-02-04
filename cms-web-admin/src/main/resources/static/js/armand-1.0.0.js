/*!
 * ArmandJS v1.0.0 (http://www.armand.com)
 * Copyright 2017.
 * Licensed under MIT.
 */

"use strict";

/**
 * Libraries:
 *  - jQuery
 *  - Handlebars
 *
 * Custom support:
 *  --> Loading
 *  --> AJAX
 *  --> Validation
 *  --> Show / Hide
 *  --> Disable / UnDisable
 *
 *  More information you can find in their parts.
 *  HINT: Search the file for the name (example: search for: --> Validation)
 */

(function($) {
	/**
	 * Global initialization.
	 */
	var globalTemp = "";

	$.noConflict();
	$(document).ready(function() {
		init("body");
		loadingInit();
	});

	/*
	 * Initalizaes all needed hoocks for javascript logic
	 */
	function init(elementSelector) {
		selectedInit(elementSelector);
		validateInit(elementSelector);
		ajaxInit(elementSelector);
		showHideInit(elementSelector);
		disableInit(elementSelector);
	}
	
	
	/**
     *  --> Loading. Loading is triggered only on data-load attribute.
     *  Sending data attributes:
     *    - data-load: URL for ajax call. The method is always GET. The result is object send to #main haze.
     */
	/*
	 * Set Ajax behavior for all elements that have "data-url" set.
	 */
	function loadingInit() {
		$('[data-load]').each(function() {
			var element = $(this);
			var url = element.attr("data-load");
			if (url !== undefined) {
				ajaxCall("GET", url, undefined, element.attr('id'));
			}
		});
	}
	

	/*
	 * Select the options where data-selected is set.
	 */
	function selectedInit(elementSelector) {
		// do selection if some option is selected
		$(elementSelector).find("[data-selected]").each(function() {
			var element = $(this);
			var value = element.attr("data-selected");
			setValue(element, value, false);
		});
	}
	
	
	/**
     *  --> AJAX. Ajax Support is set on any element with data-url attribute.
     *  Sending data attributes:
     *    - data-url: URL for ajax call
     *    - data-method: GET or POST
     *    - data-selft-submit: submits the data when all mandatory fields are filled and the focus is out
     *                        from the last validated mandatory field
     *
     *  JSON data attribute:
     *    - data-json: create JSON data object or not (true or false)
     *    - data-field: If this attribute exist, then the element value is takken into the JSON data
     *                  (regarding is it "true" or "false").
     *                  If the value is "true" then that element is put in the validation.
     *                  If the value is "false" then that element can make AJAX call to the given data-url.
     *    - data-group: when creating the JSON data object, the values of the object,
     *                  are created from all <input> or <select> with the same data-group
     *    - data-extends: support of first level group ONLY inheritance. Which group is extended.
     *    - data-sub-groups: list of groups (separated with ','). With this, in the JSON data object,
     *                       a new objects will be created based on the groups
     *    - data-prefix: if you want to send the same Data but using different Group then use the prefix
     *
     *  Field value special handling attributes:
     *    - data-frozen: (true or false) if the field has "true" set, then it's value will never be changed
     *    - data-clear: clears the validation before triggering a new validation and before sending the AJAX request
     *
     *  Front-end displaying attribute:
     *    - data-spinner: create AJAX spinner or not
     *    - data-spinner-location: if the spinner flag is set to true and this attribute is not present then
     *                             the spinner img is created next to the element. But with this attribute
     *                             you can provide location (element selector) where to create the spinner.
     *    - data-scroll: scroll to the given element selector
     */

	/*
	 * Set Ajax behavior for all elements that have "data-url" set.
	 */
	function ajaxInit(elementSelector) {
		$(elementSelector).find('[data-url]').each(function() {
			var element = $(this);

			if (element.attr("data-self-submit") === "true") {
				// self submitting
				ajaxSelfSubmit(element);
			}

			if (element.is("button") || element.is("a") || element.is("span")) {
				// click
				element.on("click", function(event) {
					return ajaxClick(this);
				});

			} else if (element.is("select")) {
				// select
				element.on("change", function(event) {
					ajaxSelect(this);
				});

			} else if (element.is("form")) {
				// submit
				element.on("submit", function(event) {
					return ajaxClick(this);
				});
			}

		});
	}

	/*
	 * Set Ajax behavior for button.
	 */
	function ajaxClick(elementSelector) {
		var element = $(elementSelector);
		ajaxClear(elementSelector);

		if (validateGroups(elementSelector, true)) {
			var url = element.attr('data-url');
			ajaxBehaviour(element, url);

		} else if (element.attr("data-validation-scroll") === "true") {
			scrollToFirstError();
		}
		return false;
	}

	/*
	 * Set Ajax behavior for select.
	 */
	function ajaxSelect(elementSelector) {
		var element = $(elementSelector);
		ajaxClear(elementSelector);

		if (validateGroups(elementSelector, true)) {
			var url = doSelectOption(element);
			if (url !== undefined) {
				ajaxBehaviour(element, url);
			}

		} else if (element.attr("data-validation-scroll") === "true") {
			scrollToFirstError();
		}
	}

	/*
	 * Set Ajax behavior for self submiting elements.
	 */
	function ajaxSelfSubmit(elementSelector) {
		var element = $(elementSelector);
		var group = element.attr("data-group");
		var extendsGroup = element.attr("data-extends");
		var prefix = getPrefix(element);

		// add the self contain behavior
		$("input[data-group='" + prefix + group + "'][data-field='true']")
				.add("select[data-group='" + prefix + group + "'][data-field='true']")
				.add("input[data-group='" + prefix + extendsGroup + "'][data-field='true']")
				.add("select[data-group='" + prefix + extendsGroup + "'][data-field='true']")
				.each(function() {

			var innerElement = $(this);

			// set the focus out event to all input and select that don't
			// have data-url set
			if (innerElement.attr("data-url") === undefined) {

				if (innerElement.is("a")) {
					// click event for anchor
					innerElement.click({mainElementId : element.attr("id")}, function(innerEvent) {

						// get the main element and validate him
						var mainElement = $("[id='" + innerEvent.data.mainElementId + "']");
						ajaxClear(innerEvent.data.mainElementId);

						// validate
						if (validateGroups(mainElement, false)) {
							ajaxBehaviour(mainElement, mainElement.attr("data-url"));
						}
					});

				} else {
					// focus out event
					innerElement.focusout({mainElementId : element.attr("id")}, function(innerEvent) {
						var lastElement = $(this);

						// check if the value is changed
						if (globalTemp !== getValue(lastElement)) {

							// get the main element and
							// validate him
							var mainElement = $("[id='" + innerEvent.data.mainElementId + "']");
							ajaxClear(innerEvent.data.mainElementId);

							// validate
							if (validateGroups(mainElement, false)) {
								ajaxBehaviour(mainElement, mainElement.attr("data-url"));
							}
						}

					});
				}
			}

		});
	}

	/*
	 * Check the selected option's value and take the needed action. 
	 * Also handles the show / hide.
	 */
	function doSelectOption(element) {
		// url
		var url = element.attr("data-url");

		// show / hide
		doShowHide(true, element);

		// return url
		return url;
	}

	/*
	 * Clears the validation for all fields that have data-clear="true".
	 */
	function ajaxClear(elementSelector) {
		var element = $(elementSelector);
		var group = element.attr('data-group');
		var prefix = getPrefix(element);

		$("[data-group='" + prefix + group + "'][data-clear='true']").each(function() {
			validateClear($(this));
		});
	}

	/*
	 * Makes AJAX call by processing the "data" attributes.
	 */
	function ajaxBehaviour(element, url) {
		// init
		var method = element.attr('data-method');
		var dataVar = undefined;

		// disable the element
		element.attr("disabled", "disabled");

		// hide all panel messages that have no group
		$("p[data-field]:not([data-group])").hide();

		// check if JSON data creation is needed
		if (element.attr('data-json') === "true") {

			// create data for the group
			var group = element.attr('data-group');
			dataVar = createDataForGroup(group, element.attr('data-extends'), getPrefix(element));
			var dataWrap = $(dataVar);

			// add additional data groups confirugred as sub-groups
			var subGroupsAll = element.attr('data-sub-groups');
			if (subGroupsAll !== undefined) {
				var subGroups = subGroupsAll.split(",");
				for ( var i = 0; i < subGroups.length; i++) {
					var groupDataVar = createDataForGroup(subGroups[i], undefined, "");
					if ($.isEmptyObject(groupDataVar)) {
						groupDataVar = undefined;
					}
					dataWrap.attr(subGroups[i], groupDataVar);
				}
			}
		}

		// ajax call
		ajaxCall(method, url, dataVar, element.attr('id'));
	}

	/*
	 * Creates JSON data for the given group.
	 */
	function createDataForGroup(group, extendGroup, prefix) {
		var dataVar = {};
		var dataWrap = $(dataVar);

		// create data
		$("[data-group='" + group + "'][data-field]").add("[data-group='" + extendGroup + "'][data-field]").each(function() {

			// init
			var innerElement = $(this);

			// name
			var name = innerElement.attr("id");
			if (prefix !== undefined) {
				name = name.replace(prefix, "");
			}

			// data elements
			if (innerElement.is("input") || innerElement.is("textarea") || innerElement.is("select") || innerElement.hasClass("fake-input")) {
				dataWrap.attr(name, getValue(innerElement));

			} else if (innerElement.is("span") || innerElement.is("p")) {
				innerElement.hide();
			}

		});

		return dataVar;
	}

	/*
	 * Makes AJAX call and process the response.
	 */
	function ajaxCall(method, url, dataVar, elementId) {
		// for GET, add the parameters in URL query
		var dataFinal = undefined;
		if (dataVar !== undefined) {
			if (method === 'GET') {
				dataFinal = $.param(dataVar);
			} else {
				dataFinal = JSON.stringify(dataVar);
			}
		}
		
		// AJAX
		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");
		$.ajax({
			method : method,
			url : url,
			contentType : "application/json; charset=UTF-8",
			dataType : "json",
			data : dataFinal,
			context : {
				elementId : elementId
			},

			beforeSend : function(xhr) {
				// add CSRF token
				xhr.setRequestHeader(header, token);
				
				// get main element
				var mainElement = $("[id=" + this.elementId + "]");

				// check if flag is set
				if (mainElement.attr("data-spinner") === "true") {

					// get the element
					var element = $(mainElement.attr("data-spinner-location"));
					if (element.length === 0) {
						element = mainElement;
					}
					
					// create ajax spinner img
					$(element).after("<span id='" + this.elementId + "_ajax' class='ajax-loader'></span>");
					
				} else {
					// fall back are the alerts
					$("#ajax-send").show();
				}
			},

			complete : function(xhr) {
				// get element
				var element = $("[id=" + this.elementId + "]");

				// check if flag is set
				if (element.attr("data-spinner") === "true") {

					// remove the loader gif
					$("span[id='" + this.elementId + "_ajax']").remove();
					
				} else {
					// fall back are the alerts
					$("#ajax-send").hide();
					$("#ajax-complete").show();
					$("#ajax-complete").delay(1000).fadeOut(500);
				}
				
				// scroll to
				if (element.attr("data-scroll") !== undefined) {
					var scrollElement = $(element.attr("data-scroll"));
					if (scrollElement.length > 0) {
						scrollTo(scrollElement[0]);
					}
				}
			}

		}).done(function(x) {

			// check if a redirect is set
			if (!x.redirect) {

				// make element in function
				var hasError = false;
				var element = $("[id=" + this.elementId + "]");
				element.removeAttr("disabled");
				
				// prefix
				var prefix = getPrefix(element);

				// renders the Fragments
				for ( var key in x.fragments) {
					var fragment = x.fragments[key];
					
					// find the HTML fragment
					var htmlFragment = $("[id='" + fragment.id + "']");
					var htmlReplace = $("[id='" + fragment.replaceId + "']");
					
					// check if the replacement can be done (is valid)
					if (htmlFragment.length > 0 && htmlReplace.length > 0) {
						
						// do replace
						var handlebarTemplate = Handlebars.compile(htmlFragment.html());
						var newHtml = handlebarTemplate(fragment.data);
						htmlReplace.html(newHtml);
						
						// init all again in the fragment after the replace
						init("[id='" + fragment.replaceId + "']");
						
						// show or hide
						if (fragment.show) {
							$(htmlReplace).show();
						} else {
							$(htmlReplace).hide();
						}
					}
				}

				// set validation messages
				for ( var key in x.messages) {
					// get the value
					var value = x.messages[key];

					// handle the prefix
					var tempPrefix = prefix;
					if (value.ignorePrefix) {
						tempPrefix = "";
					}

					// find the element
					var temp = $("[id='" + tempPrefix + key + "']");
					if (temp.length > 0) {

						// show and set the message
						if (value.text !== undefined && !!$.trim(value.text)) {
							temp.show();
							setValueHtml(temp, value.text);

							// check if it's error or
							// success
							if (value.error) {
								hasError = true;

								// change the class for
								// paragraph
								if (temp.is("p")) {
									temp.removeClass("panel-message-error");
									temp.removeClass("panel-message-success");
									temp.addClass("panel-message-error");
								}

								// add error class to
								// field
								if (value.field !== undefined) {
									$("[id='" + tempPrefix + value.field + "']").removeClass("validated").addClass("error");
								}

							} else if (temp.is("p")) {
								// change the class for
								// paragraph
								temp.removeClass("panel-message-error");
								temp.removeClass("panel-message-success");
								temp.addClass("panel-message-success");

								// add validated class
								// to field
								if (value.field !== undefined) {
									$("[id='" + tempPrefix + value.field + "']").removeClass("error").addClass("validated");
								}
							}

						} else {
							// if there is no message then
							// hide the panel
							temp.hide();
							setValue(temp, "");

							// clear the classes for the
							// field
							if (value.field !== undefined) {
								$("[id='" + tempPrefix + value.field + "']").removeClass("error").removeClass("validated");
							}
						}

					}
				}

				// set text snippets by finding the element ONLY by ID
				for ( var key in x.snippets) {
					var temp = $("[id='" + key + "']");
					if (temp.length > 0 && !(temp.attr("data-frozen") === "true")) {
						var value = x.snippets[key];

						// set the snippet (parse as HTML or
						// plain String)
						if (value.html) {
							setValueHtml(temp, value.text);
						} else {
							setValue(temp, value.text, true);
						}
					}
				}

				// checks if a submit of some form is set
				if (x.clickElement !== undefined) {
					var temp = $("[id='" + x.clickElement + "']");
					if (temp.length > 0) {
						temp.click();
					}
				}

				// move to first error field
				if (hasError && element.attr("data-validation-scroll") === "true") {
					scrollToFirstError();
				}

			} else {
				// make the redirect
				window.location.href = x.redirect;
			}

		}).fail(function(x) {
			// make element in function
			var element = $("[id=" + this.elementId + "]");
			element.removeAttr("disabled");

			// log the error
			console.log(x);

		});
	}

	/*
	 * Sets the given value on the given element.
	 */
	function setValue(element, value, triggerValidation) {
		var fieldElement = false;

		// set the value
		if (element.is("input")) {
			if (element.attr("type") === "checkbox") {
				element.prop("checked", value === "true");
			} else {
				element.val(value);
				fieldElement = true;
			}

		} else if (element.is("img")) {
			element.attr("src", value);

		} else if (element.is("select")) {
			if (element.attr("multiple") !== undefined) {
				element.val(value.split(","));
			} else {
				element.val(value);
			}
			fieldElement = true;

		} else if (element.is("textarea")) {
			element.val(value);

		} else if (element.is("form")) {
			element.attr("action", value);

		} else {
			element.text(value);
		}

		// set validated class
		if (fieldElement && triggerValidation) {
			validate(element, true);
		}
	}

	/*
	 * Sets the given value (parses it as HTML) on the given element.
	 */
	function setValueHtml(element, value) {
		var html = $.parseHTML(value);
		element.html(html);
	}

	/*
	 * Gets the value from the given element.
	 */
	function getValue(element) {
		if (element.is("input")) {
			if (element.attr("type") === "checkbox") {
				return element.prop("checked");
			} else {
				return element.val();
			}

		} else if (element.is("img")) {
			return element.attr("src");

		} else if (element.is("select")) {
			if (element.attr("multiple") !== undefined) {
				var array = [];
				element.find(":selected").each(function() {
					array.push($(this).val());
				});
				return array;
			} else {
				return element.find(":selected").val();
			}

		} else if (element.is("textarea")) {
			return element.val();

		} else if (element.is("form")) {
			return element.attr("action");

		} else {
			return $.trim(element.text());
		}
	}

	/*
	 * Returns what is empty for the element
	 */
	function getEmptyValue(element) {
		if (element.is("select")) {
			return "empty";
		} else {
			return "";
		}
	}

	/*
	 * Scroll to the first error field
	 */
	function scrollToFirstError() {
		var errorFields = $("p.panel-message-error:visible,span.error:visible");
		if (errorFields.length > 0) {
			scrollTo(errorFields[0]);
		}
	}

	/*
	 * Scroll to the given id
	 */
	function scrollTo(element) {
		$('.main-content').animate({
			scrollTop : $(element).offset().top - 100
		}, 'slow');
	}

	/*
	 * Gets the prefix for the element
	 */
	function getPrefix(element) {
		var prefix = element.attr("data-prefix");
		if (prefix === undefined) {
			prefix = "";
		}
		return prefix;
	}

	/**
     * --> Validation. Validation Support for all <input> and <select>.
     * Data attributes:
     *   - data-validation-groups: list of groups (separated with ','). Validates all groups
     *
     * Data attrubutes for the validators:
     *   - data-validation-for: id of the field for which is validation
     *   - data-validation-type: type of validation. One of:
     *                           - notEmpty
     *                           - email
     *                           - number
     *                           - range (requires attributes: num1, num2)
     *                           - length (requires attributes: num1, num2)
     *   - data-validation-num1: additional attribute needed for "range" and "length" validation types
     *   - data-validation-num2: same as num1
     *   - data-validation-scroll: scroll to the first error field if the validation fails
     *
     * Data attributes for condition validation:
     *   - data-condition: type of condition
     *   - data-condition-source: element selector to get the value from
     *   - data-condition-values: one or set of values needed for the condition
     */

	/*
	 * Sets validation triggers on all input:text with data-field attribute and
	 * all select with data-field attribute.
	 */
	function validateInit(elementSelector) {
		// focus in and out for a all input and selects
		$(elementSelector).find("input[data-field='true'],select[data-field='true']").each(function() {

			$(this).on("focusin", function() {
				// save the first value
				globalTemp = getValue($(this));
			});

			$(this).on("focusout", function() {
				// check if the value is changed
				if (globalTemp !== getValue($(this))) {

					// validate the element
					validate($(this), true);
				}
			});
		});

		$(elementSelector).find("select[data-field='true']").each(function() {
			$(this).on("change", function() {
				var element = $(this);
				var elementId = element.attr("id");
				var validators = $("[data-validation-for='" + elementId + "']");

				if (validators.length > 0) {
					// show the ajax spinner
					element.addClass("now-validating");

					// validate the element
					validate(this, true);

					// remove the spinner
					element.removeClass("now-validating");
				}
			});

		});
	}

	/*
	 * Trigger the validation on the groups for the given element.
	 */
	function validateGroups(elementSelector, updateGui) {
		var element = $(elementSelector);
		var prefix = getPrefix(element);
		var allGroups = element.attr('data-validation-groups');
		var ok = true;

		if (allGroups !== undefined) {
			var groups = allGroups.split(',');
			for ( var i = 0; i < groups.length; i++) {
				ok = validateGroup(prefix + groups[i], updateGui) && ok;
			}
		}

		return ok;
	}

	/*
	 * Triggers the validation on the given group.
	 */
	function validateGroup(group, updateGui) {
		var ok = true;
		$("[data-group='" + group + "']").each(function() {
			ok = validate(this, updateGui) && ok;
		});
		return ok;
	}

	/*
	 * Triggers the validation on the given element.
	 */
	function validate(elementSelector, updateGui) {
		// init
		var element = $(elementSelector);
		var elementId = element.attr("id");

		// get all field validator
		var validators = $("[data-validation-for='" + elementId + "'],[data-condition-source='" + elementId + "']");

		// get the result from the validators (break on first fail)
		var ok = true;
		var hasFakeValidator = false;
		var message = "";
		for ( var i = 0; i < validators.length; i++) {
			var validator = $(validators[i]);

			// switch the validation context if the required element is not
			// the current one
			if (elementId !== validator.attr("data-validation-for")) {
				validate("#" + validator.attr("data-validation-for"), updateGui);
				continue;
			}

			// check if there is condition set at the validator
			var conditionOk = false;
			var condition = validator.attr("data-condition");
			if (condition === "oneOf") {
				var sourceValue = getValue($("[id='" + validator.attr("data-condition-source") + "']"));
				var values = validator.attr("data-condition-value").split(",");
				for ( var j = 0; j < values.length; j++) {
					if (values[j] === sourceValue) {
						conditionOk = true;
					}
				}

			} else {
				conditionOk = true;
			}

			// condinue with validation
			if (conditionOk) {

				// get the type
				var type = validator.attr("data-validation-type");
				message = validator.text();

				// find the function for the validator type
				if (type === "notEmpty") {
					ok = validateNotEmpty(element);
				} else if (type === "email") {
					ok = validateEmail(element);
				} else if (type === "number") {
					ok = validateNumber(element);
				} else if (type === "range") {
					ok = validateRange(element, validator.attr("data-validation-num1"), validator.attr("data-validation-num2"));
				} else if (type === "length") {
					ok = validateLength(element, validator.attr("data-validation-num1"), validator.attr("data-validation-num2"));
				} else if (type === "fake") {
					hasFakeValidator = true;
				} else if (type = "isChecked") {
					ok = validateChecked(element);
				}
			}

			// break on first fail
			if (!ok) {
				break;
			}
		}

		// update the GUI
		if (validators.length > 0) {
			if (hasFakeValidator && getValue(element) === getEmptyValue(element)) {
				if (updateGui) {
					validateClear(element);
				}
				ok = true;
			} else {
				if (updateGui) {
					validateUpdateGUI(element, ok, message);
				}
			}
		}
		return ok;
	}

	/*
	 * Updates the GUI for the element with validation result
	 */
	function validateUpdateGUI(element, valid, message) {
		// init
		var parent = element.parent();
		var messageSpan = $("span[id='" + element.attr("id") + "_message']");

		if (!valid) {
			// if the result is FALSE, then wrap the field as error
			if (message !== undefined && !!$.trim(message)) {
				element.addClass("error");
				element.removeClass("validated");
				messageSpan.show();
				messageSpan.text(message);
				if (element.is("select")) {
					parent.find(".select-validated").hide();
				}
			}

		} else {
			// if the result is TRUE, then set the check sign
			element.removeClass("error");
			element.addClass("validated");
			messageSpan.hide();
			messageSpan.text("");
			if (element.is("select")) {
				parent.find(".select-validated").show();
			}
		}
	}

	/*
	 * Clears all validation for the element.
	 */
	function validateClear(element) {
		// init
		var messageSpan = $("span[id='" + element.attr("id") + "_message']");

		// clear the classes and text
		element.removeClass("error");
		element.removeClass("validated");
		messageSpan.hide();
		messageSpan.text("");
		if (element.is("select")) {
			var parent = element.parent();
			parent.find(".select-validated").hide();
		}
	}

	/*
	 * Checks if the element value is empty.
	 */
	function validateNotEmpty(element) {
		if (element.is("select")) {
			return element.find(":selected").val() !== "empty";
		} else if (element.is("input")) {
			return !!$.trim(element.val());
		} else {
			return false;
		}
	}

	/*
	 * Checks if the element value is email.
	 */
	function validateEmail(element) {
		var value = element.val();
		var atpos = value.indexOf("@");
		var dotpos = value.lastIndexOf(".");
		if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= value.length) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Checks if the element value is number.
	 */
	function validateNumber(element) {
		var value = element.val();
		return isNumber(value);
	}

	/*
	 * Checks if the element value is number beween the given range.
	 */
	function validateRange(element, min, max) {
		var value = element.val();
		if (!isNumber(min)) {
			min = -999999999;
		}
		var max = element.attr("data-validation-num2");
		if (!isNumber(max)) {
			max = 999999999;
		}
		return min <= value && value <= max;
	}

	/*
	 * Checks if the element value length is between the given boundaries.
	 */
	function validateLength(element, min, max) {
		var value = element.val();
		if (typeof value === "string") {
			value = value.length;
		} else {
			value = 0;
		}
		if (!isNumber(min)) {
			min = -999999999;
		}
		if (!isNumber(max)) {
			max = 999999999;
		}
		return min <= value && value <= max;
	}

	/*
	 * Checks if the element has checked attribute.
	 */
	function validateChecked(element) {
		return element.attr("checked") === "checked";
	}

	/*
	 * Is the given value number.
	 */
	function isNumber(value) {
		return value >= 0 || value < 0;
	}

	/*
	 * Prevent textfield from exeeding defined max length
	 */
	function isMaxLength(obj, mlength) {
		if (obj.getAttribute && obj.value.length > mlength) {
			obj.value = obj.value.substring(0, mlength);
		}
	}

	
	
	
	/**
	 * --> Show / Hide. Show / hide support for all elements.
	 * Data attributes: 
	 *   - data-show-hide: element selector
	 */

	/*
	 * Initialize all elements that have data-show-hide
	 */
	function showHideInit(elementSelector) {
		$(elementSelector).find("[data-show-hide]").each(function() {
			var element = $(this);

			if (element.is("input")) {
				// checkbox
				if (element.attr("type") === "checkbox") {
					element.on("click", function() {
						doShowHide($(this).prop("checked"), $(this));
					});
				}
			}
		});
	}

	/*
	 * Does the show / hide action
	 */
	function doShowHide(show, element) {
		var showHideTargetsSelector = element.attr("data-show-hide");
		if (showHideTargetsSelector !== undefined) {
			var targets = showHideTargetsSelector.split(',');
			for ( var i = 0; i < targets.length; i++) {
				var target = $(targets[i]);
				if (target.length > 0) {
					if (show) {
						target.show();
					} else {
						target.hide();
					}
				}

			}
		}
	}

	
	
	
	/**
	 * --> Disable / Enable. Disable / enable support for all elements.
	 * Data attributes:
	 *   - data-disable: element selector
	 */

	/*
	 * Initialize all elements that have data-disable
	 */
	function disableInit(elementSelector) {
		$(elementSelector).find("[data-disable]").each(function() {
			var element = $(this);

			if (element.is("input")) {
				// checkbox
				if (element.attr("type") === "checkbox") {
					element.on("click", function() {
						doDisable($(this).prop("checked"), $(this));
					});
				}
			}
		});
	}

	/*
	 * Does the show / hide action
	 */
	function doDisable(undisable, element) {
		var disableTarget = element.attr("data-disable");
		if (disableTarget !== undefined) {
			var target = $(disableTarget);
			if (target.length > 0) {
				if (undisable) {
					target.removeAttr("disabled");
				} else {
					target.attr("disabled", "disabled");
				}
			}
		}
	}

})(jQuery);