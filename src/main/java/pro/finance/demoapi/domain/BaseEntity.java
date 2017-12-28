package pro.finance.demoapi.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue
	@Column(name="id", nullable = false)
	private UUID id = UUID.randomUUID();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("BaseEntity{");
		sb.append("id=").append(id);
		sb.append('}');
		return sb.toString();
	}
}
