package entities;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class BaseEntity {
	@Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }
}
