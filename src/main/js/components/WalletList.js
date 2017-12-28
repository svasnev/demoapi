const React = require('react');

export default class WalletList extends React.Component{
	render() {
		var wallets = this.props.wallets.map(wallet =>
			<Wallet key={wallet.id} wallet={wallet}/>
		);
		return (
			<div>
				<h1>Wallets:</h1>
				<table>
					<tbody>
						{wallets}
					</tbody>
				</table>
			</div>
		)
	}
}


class Wallet extends React.Component{
	render() {
		return (
			<tr>
				<td>Wallet number: {this.props.wallet.number}</td>
				<td>Balance: {this.props.wallet.balance}</td>
			</tr>
		)
	}
}