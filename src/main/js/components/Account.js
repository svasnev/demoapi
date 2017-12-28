


const Cards = require('./Cards.js').default;
const Wallets = require('./Wallets.js').default;
const AccountName = require('./AccountName.js').default;

const React = require('react');
const client = require('../client');
const Link = require('react-router-dom').Link;

export default class Account extends React.Component {


	constructor(props) {
		super(props);
		this.state = {account: {}};
		console.log(props);
	}

	componentWillMount(){
		client('/api/systemAccounts/' + this.props.match.params.accountId)
			.done(response => {this.setState({account: response.entity})});
	}

	render(){

		let child;

		switch(this.props.match.params.child){
			case 'cards':
				child =  <Cards accountId = {this.props.match.params.accountId}/>;
				break;
			case 'wallets':
				child = <Wallets accountId = {this.props.match.params.accountId}/>;
				break;
			default:
				child = null;
				break;
		}
		console.log(this.props.match.params.child);
		console.log(this.props.match.params.child);

		return (
				<div>
					<AccountName systemAccount={this.state.account}/>
						{child}
						{'wallets' != this.props.match.params.child ?
							(<Link to={'/account/' + this.props.match.params.accountId + '/wallets'}>Wallets</Link>)
							: ''

						}

						{'cards' != this.props.match.params.child ?
							(<Link to={'/account/' + this.props.match.params.accountId + '/cards'}>Cards</Link>)
							: ''
						}
				</div>

						);

	}

}

