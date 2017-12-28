const React = require('react');
const client = require('../client');

export default class AddCard extends React.Component {


	constructor(props) {
		super(props);
		this.state = {value: '', error: ''};
		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleChange = this.handleChange.bind(this);
		this.handleOk = this.handleOk.bind(this);
		this.handleError = this.handleError.bind(this);
	}

	handleSubmit(event) {
		client({path: '/api/' + this.props.accountId + '/cards', method: 'POST', entity:  this.state.value})
			.then(this.handleOk, this.handleError);
		event.preventDefault()
	}

	handleOk() {
		this.props.update();
	}

	handleError(response) {
		this.setState({error: 'Invalid email or account not found.'});
	}

	handleChange(event) {
		this.setState({value: event.target.value});
	}


	render() {

		const form = <form onSubmit={this.handleSubmit}>
			<label>
				Add card:
				<input type="text" value={this.state.value} onChange={this.handleChange}/>
			</label>
			<input type="submit" value="Submit"/>
			{this.state.error}
		</form>
		return form;
	}

}