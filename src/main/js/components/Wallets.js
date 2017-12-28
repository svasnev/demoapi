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
		client('/api/' + this.props.accountId + '/wallets')
			.done(response => {this.setState({wallets: response.entity})});
	}

	render() {
		return ( <div>
			<WalletList wallets={this.state.wallets}/>
		</div>)

	}
}