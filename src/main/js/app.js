const React = require('react');
const ReactDOM = require('react-dom');
const rest = require('rest');
const mime = require('rest/interceptor/mime');
const client = rest.wrap(mime);

class SystemAccount extends React.Component {

    constructor(props) {
        super(props);
        this.state = {accountEmail: '',systemAccount: {}, cards: [], wallets: [], counter: 0};

        this.accountSearch=this.accountSearch.bind(this)
    }



    componentDidMount() {

    }

    accountSearch(email){
        console.log("Account search");
        client('/api/systemAccounts?email=' + email).done(response => {
            this.setState({systemAccount: response.entity});
            client('/api/' + response.entity.id + '/cards')
                .done(response1 => {this.setState({cards: response1.entity})});

            client('/api/' + response.entity.id + '/wallets')
                .done(response2 => {this.setState({wallets: response2.entity})});
        })

    }

    render() {
        let componentValue = null;
        if( Object.keys(this.state.systemAccount).length === 0){
            console.log("Render search");
            return <Search searchAccount={this.accountSearch}/>
        }
        else{
            console.log("Render divs");
            return( <div>
                <h1>{this.state.systemAccount.firstName} {this.state.systemAccount.lastName}</h1>
                <CardList cards={this.state.cards}/>
                <WalletList wallets={this.state.wallets}/>
            </div>)
        }
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

class Search extends React.Component{

    constructor(props) {
        super(props);
        this.state = {value: ''};
        this.handleSearch = this.handleSearch.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleSearch(event){
        this.props.searchAccount(this.state.value);
        event.preventDefault();
    }
    handleChange(event) {
        this.setState({value: event.target.value});
    }

    render(){

        const form = <form onSubmit={this.handleSearch}>
            <label>
                Search account by email:
                <input type="text" value ={this.state.value} onChange={this.handleChange}/>
            </label>
            <input type="submit" value="Submit" />
        </form>
        return form;
    }


}

ReactDOM.render(
    <SystemAccount />,
    document.getElementById('react')
)


