const React = require('react');
const ReactDOM = require('react-dom');
const BrowserRouter = require('react-router-dom').BrowserRouter;
const Switch = require('react-router-dom').Switch;
const Route = require('react-router-dom').Route;
const Search = require('./components/Search.js').default;
const Account = require('./components/Account.js').default;

class Application extends React.Component{


	render() {
	    return (<Switch>
            <Route exact path='/' component={Search}/>
		    <Route exact path='/account/:accountId' component={Account}/>
		    <Route exact path='/account/:accountId/:child' component={Account}/>
	    </Switch>);
	}

}

ReactDOM.render(
    <BrowserRouter>
        <Application />
    </BrowserRouter>,
    document.getElementById('react')
)


