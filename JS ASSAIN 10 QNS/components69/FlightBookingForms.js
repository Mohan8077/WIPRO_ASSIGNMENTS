// not yet done
import React, { Component, createRef } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

// -----------------------------
// Controlled Component
// -----------------------------
class FlightBookingControlled extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      gender: '',
      meal: 'Veg',
      request: '',
      submitted: false,
    };
  }

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({ submitted: true });
  };

  render() {
    const { name, email, gender, meal, request, submitted } = this.state;

    return (
      <div className="col-md-6 mb-4">
        <h4>Controlled Flight Booking Form</h4>
        <form onSubmit={this.handleSubmit}>
          <div className="mb-2">
            <label>Passenger Name</label>
            <input
              type="text"
              name="name"
              className="form-control"
              value={name}
              onChange={this.handleChange}
            />
          </div>

          <div className="mb-2">
            <label>Email</label>
            <input
              type="email"
              name="email"
              className="form-control"
              value={email}
              onChange={this.handleChange}
            />
          </div>

          <div className="mb-2">
            <label>Gender</label>
            <div>
              <input
                type="radio"
                name="gender"
                value="Male"
                onChange={this.handleChange}
              />{' '}
              Male
              <input
                type="radio"
                name="gender"
                value="Female"
                className="ms-3"
                onChange={this.handleChange}
              />{' '}
              Female
            </div>
          </div>

          <div className="mb-2">
            <label>Meal Preference</label>
            <select
              name="meal"
              className="form-control"
              value={meal}
              onChange={this.handleChange}
            >
              <option value="Veg">Veg</option>
              <option value="Non-Veg">Non-Veg</option>
            </select>
          </div>

          <div className="mb-2">
            <label>Special Request</label>
            <textarea
              name="request"
              className="form-control"
              value={request}
              onChange={this.handleChange}
            ></textarea>
          </div>

          <button className="btn btn-primary">Submit</button>
        </form>

        {submitted && (
          <table className="table table-bordered mt-3">
            <thead>
              <tr>
                <th>Passenger Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Meal</th>
                <th>Special Request</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{name}</td>
                <td>{email}</td>
                <td>{gender}</td>
                <td>{meal}</td>
                <td>{request}</td>
              </tr>
            </tbody>
          </table>
        )}
      </div>
    );
  }
}

// -----------------------------
// Uncontrolled Component
// -----------------------------
class FlightBookingUncontrolled extends Component {
  constructor(props) {
    super(props);
    this.flightRef = createRef();
    this.sourceRef = createRef();
    this.destinationRef = createRef();
    this.dateRef = createRef();
    this.termsRef = createRef();

    this.state = {
      submitted: false,
      flightDetails: {},
    };
  }

  handleSubmit = (e) => {
    e.preventDefault();

    const details = {
      flight: this.flightRef.current.value,
      source: this.sourceRef.current.value,
      destination: this.destinationRef.current.value,
      date: this.dateRef.current.value,
      termsAccepted: this.termsRef.current.checked,
    };

    this.setState({
      flightDetails: details,
      submitted: true,
    });
  };

  render() {
    const { submitted, flightDetails } = this.state;

    return (
      <div className="col-md-6 mb-4">
        <h4>Uncontrolled Flight Booking Form</h4>
        <form onSubmit={this.handleSubmit}>
          <div className="mb-2">
            <label>Flight Number</label>
            <input type="text" className="form-control" ref={this.flightRef} />
          </div>

          <div className="mb-2">
            <label>Source</label>
            <input type="text" className="form-control" ref={this.sourceRef} />
          </div>

          <div className="mb-2">
            <label>Destination</label>
            <input type="text" className="form-control" ref={this.destinationRef} />
          </div>

          <div className="mb-2">
            <label>Travel Date</label>
            <input type="date" className="form-control" ref={this.dateRef} />
          </div>

          <div className="form-check mb-2">
            <input type="checkbox" className="form-check-input" ref={this.termsRef} />
            <label className="form-check-label">Terms Accepted</label>
          </div>

          <button className="btn btn-dark">Submit</button>
        </form>

        {submitted && (
          <div className="card mt-3 p-3">
            <h5>Flight Details</h5>
            <p><strong>Flight Number:</strong> {flightDetails.flight}</p>
            <p><strong>Source:</strong> {flightDetails.source}</p>
            <p><strong>Destination:</strong> {flightDetails.destination}</p>
            <p><strong>Date:</strong> {flightDetails.date}</p>
            <p><strong>Terms Accepted:</strong> {flightDetails.termsAccepted ? 'Yes' : 'No'}</p>
          </div>
        )}
      </div>
    );
  }
}

// -----------------------------
// Parent Component
// -----------------------------
class FlightBookingForms extends Component {
  render() {
    return (
      <div className="container my-5">
        <div className="row">
          <FlightBookingControlled />
          <FlightBookingUncontrolled />
        </div>
      </div>
    );
  }
}

export default FlightBookingForms;
