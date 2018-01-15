package com.armand.cms.core.date;

import java.util.Set;

import com.armand.cms.core.utils.Utils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DurationType {
  Long(Utils.asSet(DurationUnit.Year, DurationUnit.Month, DurationUnit.Day)),
  Short(Utils.asSet(DurationUnit.values()));

  private Set<DurationUnit> units;

  public boolean isDurationUnitSupported(DurationUnit durationUnit) {
    return units.contains(durationUnit);
  }
}
