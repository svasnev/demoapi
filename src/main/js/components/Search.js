const React = require('react');
const client = require('../client');
const Redirect = require('react-router-dom').Redirect;


export default class Search extends React.Component {

	constructor(props) {
		super(props);
		this.state = {value: '', systemAccountId: ''};
		this.handleSearch = this.handleSearch.bind(this);
		this.handleChange = this.handleChange.bind(this);
		this.fillAccountData = this.fillAccountData.bind(this);
		this.handleError = this.handleError.bind(this);
	}

	handleSearch(event) {

		client('/api/systemAccounts?email=' + this.state.value)
			.then(this.fillAccountData, this.handleError)
		event.preventDefault();
	}

	fillAccountData(response) {
		this.props.history.push('/account/' + response.entity.id);
	}

	handleError(response) {
		this.setState({error: 'Invalid email or account not found.'});
	}

	handleChange(event) {
		this.setState({value: event.target.value});
	}

	render() {

			const form = <form onSubmit={this.handleSearch}>
				<label>
					Search account by email:
					<input type="text" value={this.state.value} onChange={this.handleChange}/>
				</label>
				<input type="submit" value="Submit"/>
				{this.state.error}
			</form>
			return form;
	}


}