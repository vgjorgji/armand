package com.armand.cms.core.date;

import java.util.Set;

import com.armand.cms.core.utils.Utils;

public enum DurationType {
	Long(Utils.asSet(DurationUnit.Year, DurationUnit.Month, DurationUnit.Day)),
	Short(Utils.asSet(DurationUnit.values()));
	
	private Set<DurationUnit> units;

	private DurationType(Set<DurationUnit> units) {
		this.units = units;
	}
	
	public boolean isDurationUnitSupported(DurationUnit durationUnit) {
		return units.contains(durationUnit);
	}
}
