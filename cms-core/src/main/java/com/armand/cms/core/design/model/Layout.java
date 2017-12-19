package com.armand.cms.core.design.model;

public class Layout {
	
	private boolean top = false;
	private boolean left = false;
	private boolean right = false;
	private boolean bottom = false;
	
	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public String getCenterColumnCss() {
		if (!left && !right) {
			return "col-md-12";
		} else if (left && right) {
			return "col-md-4";
		} else {
			return "col-md-8";
		}
	}
	
}
