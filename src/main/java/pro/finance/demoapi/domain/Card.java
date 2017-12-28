package pro.finance.demoapi.domain;

import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "card")
public class Card extends BaseEntity {

	public Card(){

	}

	public Card(SystemAccount account, String cardNumber){
		super();
		this.systemAccount = account;
		this.cardNumber = cardNumber;
	}


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "system_account_id")
	private SystemAccount systemAccount;

	@Column(name = "card_number", nullable = false, length = 50)
	private String cardNumber;


	@Column(name = "balance", nullable = false)
	private BigDecimal balance = BigDecimal.ZERO;

	public SystemAccount getSystemAccount() {
		return systemAccount;
	}

	public void setSystemAccount(SystemAccount systemAccount) {
		this.systemAccount = systemAccount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Card{");
		sb.append("systemAccount=").append(systemAccount);
		sb.append(", cardNumber='").append(cardNumber).append('\'');
		sb.append(", balance=").append(balance);
		sb.append('}');
		return sb.toString();
	}
}
