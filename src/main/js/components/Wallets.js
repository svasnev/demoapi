const React = require('react');
const client = require('../client');
const WalletList = require('./WalletList.js').default;
const Link = require('react-router-dom').Link;

export default class Wallets extends React.Component {

	constructor(props) {
		super(props);
		this.state = {wallets: []};
	}


	componentWillMount(){
		client('/api/' + this.props.match.params.accountId + '/wallets')
			.done(response => {this.setState({wallets: response.entity})});
	}

	render() {
		return ( <div>
			<WalletList wallets={this.state.wallets}/>
			<Link to={'/account/' + this.props.match.params.accountId + '/cards'} activeClassName="active">Cards</Link>
		</div>)

	}
}