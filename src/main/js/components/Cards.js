const React = require('react');
const client = require('../client');
const CardList = require('./CardList.js').default;

export default class Cards extends React.Component {

	constructor(props) {
		super(props);
		this.state = {cards: []};
	}


	componentWillMount() {
		client('/api/' + this.props.accountId + '/cards')
			.done(response => {
				this.setState({cards: response.entity})
			});
	}

	render() {
		return ( <div>
			<CardList cards={this.state.cards}/>
		</div>)

	}
}