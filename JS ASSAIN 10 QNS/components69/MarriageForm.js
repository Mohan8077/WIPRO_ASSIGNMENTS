// Import React and Component class
import React, { Component } from 'react';
// Import Bootstrap CSS for styling
import 'bootstrap/dist/css/bootstrap.min.css';

// Class component to manage marriage form
class MarriageForm extends Component {
  constructor(props) {
    super(props); // Call parent constructor
    // Define initial state values
    this.state = {
      brideName: '',   // Stores bride name
      groomName: '',   // Stores groom name
      date: '',        // Stores marriage date
      venue: '',       // Stores venue
      submitted: false // Tracks if form is submitted
    };
  }

  // Generic change handler updates state using input's "name"
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  // On form submit, prevent page reload and set submitted = true
  handleSubmit = (e) => {
    e.preventDefault(); // Prevent default form behavior
    this.setState({ submitted: true }); // Show details section
  };

  // Render UI
  render() {
    // Destructure state variables for easy use
    const { brideName, groomName, date, venue, submitted } = this.state;

    return (
      <div className="container my-4">
        {/* Card with form */}
        <div className="card p-4 shadow-sm">
          <h2 className="text-center mb-4">Marriage Form</h2>

          {/* Form starts */}
          <form onSubmit={this.handleSubmit}>
            {/* Bride Name input */}
            <div className="form-group mb-3">
              <label>Bride Name</label>
              <input
                type="text"
                className="form-control"
                name="brideName" // links with state key
                value={brideName}
                onChange={this.handleChange}
              />
            </div>

            {/* Groom Name input */}
            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                className="form-control"
                name="groomName"
                value={groomName}
                onChange={this.handleChange}
              />
            </div>

            {/* Marriage Date input */}
            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date"
                className="form-control"
                name="date"
                value={date}
                onChange={this.handleChange}
              />
            </div>

            {/* Venue input */}
            <div className="form-group mb-4">
              <label>Venue</label>
              <input
                type="text"
                className="form-control"
                name="venue"
                value={venue}
                onChange={this.handleChange}
              />
            </div>

            {/* Submit button */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show submitted details only if "submitted" is true */}
        {submitted && (
          <div className="card mt-4 p-4 shadow-sm">
            <h3 className="text-center mb-4">Marriage Details</h3>
            <ul className="list-group">
              <li className="list-group-item">
                <strong>Bride Name:</strong> {brideName}
              </li>
              <li className="list-group-item">
                <strong>Groom Name:</strong> {groomName}
              </li>
              <li className="list-group-item">
                <strong>Date:</strong> {date}
              </li>
              <li className="list-group-item">
                <strong>Venue:</strong> {venue}
              </li>
            </ul>
          </div>
        )}
      </div>
    );
  }
}

// Export so it can be used in App.js
export default MarriageForm;
