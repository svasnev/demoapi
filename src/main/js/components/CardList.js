const React = require('react');


export default class CardList extends React.Component {
	render() {
		var cards = this.props.cards.map(card =>
			<Card key={card.id} card={card}/>
		);
		return (
			<div>
				<h1>Cards:</h1>
				<table>
					<tbody>
						{cards}
					</tbody>
				</table>
			</div>
		)
	}
}


class Card extends React.Component {
	render() {
		return (
			<tr>
				<td>Card number: {this.props.card.cardNumber}</td>
				<td>Balance: {this.props.card.balance}</td>
			</tr>
		)
	}
}
