const React = require('react');
const client = require('../client');
const CardList = require('./CardList.js').default;
const AddCard = require('./AddCard.js').default;

export default class Cards extends React.Component {

	constructor(props) {
		super(props);
		this.state = {cards: []};
		this.updateState = this.updateState.bind(this);
	}

	componentDidMount() {
		this.updateState();
	}

	updateState() {
		client('/api/' + this.props.accountId + '/cards')
			.done(response => {
				this.setState({cards: response.entity})
			});
	}


	render() {
		return ( <div>
			<CardList cards={this.state.cards}/>
			<AddCard accountId={this.props.accountId} update={this.updateState}/>
		</div>)

	}
}