package pro.finance.demoapi.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wallet")
public class Wallet extends BaseEntity {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "system_account_id")
	private SystemAccount systemAccount;

	@Column(name = "number", nullable = false, length = 50)
	private String number;

	public SystemAccount getSystemAccount() {
		return systemAccount;
	}

	public void setSystemAccount(SystemAccount systemAccount) {
		this.systemAccount = systemAccount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Wallet{");
		sb.append("systemAccount=").append(systemAccount);
		sb.append(", number='").append(number).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
