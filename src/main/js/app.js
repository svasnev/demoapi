const React = require('react');
const ReactDOM = require('react-dom');
const rest = require('rest');
const mime = require('rest/interceptor/mime');
const client = rest.wrap(mime);

class SystemAccount extends React.Component {

    constructor(props) {
        super(props);
        this.state = {systemAccount: {}, cards: [], wallets: [], counter: 0};

        this.refClick=this.refClick.bind(this)
    }



    componentDidMount() {

        client('/api/systemAccounts/d16480b2-e748-11e7-80c1-9a214cf093ae')
            .done(response =>
            {
                this.setState({systemAccount: response.entity});
                client('/api/' + response.entity.id + '/cards')
                    .done(response1 => {this.setState({cards: response1.entity})});

                client('/api/' + response.entity.id + '/wallets')
                    .done(response2 => {this.setState({wallets: response2.entity})});
            });

    }

    refClick(){
        this.setState(prevState => ({
            counter: ++prevState.counter
        }));
    }

    render() {
        console.log(this);
        return (
            <div>
                <a href="#"
                   onClick={this.refClick}>
                    {this.state.systemAccount.firstName} {this.state.systemAccount.lastName}
                </a>
            <h1></h1>
               <CardList cards={this.state.cards}/>
               <WalletList wallets={this.state.wallets}/>
            </div>
    )
    }
}

class CardList extends React.Component{
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


class Card extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.card.cardNumber}</td>
            </tr>
        )
    }
}

class WalletList extends React.Component{
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
                <td>{this.props.wallet.number}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <SystemAccount />,
    document.getElementById('react')
)


