const React = require('react');

export default class AccountName extends React.Component {

	render() {
		return ( <h1>{this.props.systemAccount.firstName} {this.props.systemAccount.lastName}</h1>);
	}

}