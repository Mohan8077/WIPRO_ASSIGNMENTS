import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "bootstrap/dist/css/bootstrap.min.css";

// ----- HOC to wrap form section components -----
function withFormSection(WrappedComponent, sectionTitle) {
  return function FormSection(props) {
    return (
      <div className="mb-4 p-3 border rounded bg-light">
        <h5 className="mb-3">{sectionTitle}</h5>
        <WrappedComponent {...props} />
      </div>
    );
  };
}

// ----- Validation schema for whole form -----
const validationSchema = Yup.object({
  name: Yup.string().required("Name is required"),
  email: Yup.string()
    .email("Invalid email address")
    .required("Email is required"),
  phone: Yup.string()
    .matches(
      /^\(?\d{3}\)?[-.\s]?\d{3}[-.\s]?\d{4}$/,
      "Phone number is not valid"
    )
    .required("Phone is required"),
  organization: Yup.string().required("Organization is required"),
  ticketType: Yup.string().oneOf(["Regular", "VIP", "Student"]).required(),
  quantity: Yup.number()
    .min(1, "Quantity must be at least 1")
    .max(10, "Max 10 tickets")
    .required("Quantity is required"),
  sessions: Yup.array()
    .min(1, "At least one session must be selected")
    .required(),
  paymentMethod: Yup.string()
    .oneOf(["Credit Card", "Paypal", "Bank Transfer"])
    .required("Payment Method is required"),
  promoCode: Yup.string(),
  invoiceAddress: Yup.string().when("invoiceAddressChecked", {
    is: true,
    then: Yup.string().required("Invoice Address is required"),
  }),
  invoiceAddressChecked: Yup.boolean(),
});

// ----- Personal Details Component -----
const PersonalDetails = () => (
  <>
    <div className="mb-3">
      <label htmlFor="name" className="form-label">
        Name
      </label>
      <Field
        name="name"
        id="name"
        className="form-control"
        placeholder="John Doe"
      />
      <ErrorMessage
        name="name"
        component="div"
        className="text-danger small mt-1"
      />
    </div>

    <div className="row">
      <div className="col-md-6 mb-3">
        <label htmlFor="email" className="form-label">
          Email
        </label>
        <Field
          type="email"
          name="email"
          id="email"
          className="form-control"
          placeholder="johndoe@example.com"
        />
        <ErrorMessage
          name="email"
          component="div"
          className="text-danger small mt-1"
        />
      </div>

      <div className="col-md-6 mb-3">
        <label htmlFor="phone" className="form-label">
          Phone
        </label>
        <Field
          name="phone"
          id="phone"
          className="form-control"
          placeholder="(123) 456-7890"
        />
        <ErrorMessage
          name="phone"
          component="div"
          className="text-danger small mt-1"
        />
      </div>
    </div>

    <div className="mb-3">
      <label htmlFor="organization" className="form-label">
        Organization
      </label>
      <Field
        name="organization"
        id="organization"
        className="form-control"
        placeholder="ABC Company"
      />
      <ErrorMessage
        name="organization"
        component="div"
        className="text-danger small mt-1"
      />
    </div>
  </>
);

// ----- Ticket Selection Component -----
const TicketSelection = () => (
  <div className="row">
    <div className="col-md-6 mb-3">
      <label htmlFor="ticketType" className="form-label">
        Ticket Type
      </label>
      <Field
        as="select"
        id="ticketType"
        name="ticketType"
        className="form-select"
      >
        <option value="Regular">Regular</option>
        <option value="VIP">VIP</option>
        <option value="Student">Student</option>
      </Field>
      <ErrorMessage
        name="ticketType"
        component="div"
        className="text-danger small mt-1"
      />
    </div>

    <div className="col-md-6 mb-3">
      <label htmlFor="quantity" className="form-label">
        Quantity
      </label>
      <Field
        type="number"
        id="quantity"
        name="quantity"
        min="1"
        max="10"
        className="form-control"
      />
      <ErrorMessage
        name="quantity"
        component="div"
        className="text-danger small mt-1"
      />
    </div>
  </div>
);

// ----- Session Preferences Component -----
const sessionsOptions = [
  { label: "Workshop A", value: "Workshop A" },
  { label: "Panel B", value: "Panel B" },
  { label: "Keynote", value: "Keynote" },
];

const SessionPreferences = ({ values, setFieldValue }) => {
  const handleCheckboxChange = (event) => {
    const { checked, value } = event.target;
    if (checked) {
      setFieldValue("sessions", [...values.sessions, value]);
    } else {
      setFieldValue(
        "sessions",
        values.sessions.filter((v) => v !== value)
      );
    }
  };

  return (
    <div>
      {sessionsOptions.map((session) => (
        <div key={session.value} className="form-check">
          <input
            type="checkbox"
            className="form-check-input"
            id={session.value}
            name="sessions"
            value={session.value}
            checked={values.sessions.includes(session.value)}
            onChange={handleCheckboxChange}
          />
          <label className="form-check-label" htmlFor={session.value}>
            {session.label}
          </label>
        </div>
      ))}
      <ErrorMessage
        name="sessions"
        component="div"
        className="text-danger small mt-1"
      />
    </div>
  );
};

// ----- Payment Details Component -----
const PaymentDetails = ({ values, setFieldValue }) => {
  const handleInvoiceToggle = () => {
    setFieldValue("invoiceAddressChecked", !values.invoiceAddressChecked);
    if (values.invoiceAddressChecked) {
      setFieldValue("invoiceAddress", "");
    }
  };

  return (
    <>
      <div className="row mb-3">
        <div className="col-md-6">
          <label htmlFor="paymentMethod" className="form-label">
            Payment Method
          </label>
          <Field
            as="select"
            id="paymentMethod"
            name="paymentMethod"
            className="form-select"
          >
            <option value="">Select</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Paypal">Paypal</option>
            <option value="Bank Transfer">Bank Transfer</option>
          </Field>
          <ErrorMessage
            name="paymentMethod"
            component="div"
            className="text-danger small mt-1"
          />
        </div>

        <div className="col-md-6">
          <label htmlFor="promoCode" className="form-label">
            Promo Code
          </label>
          <Field
            type="text"
            id="promoCode"
            name="promoCode"
            className="form-control"
            placeholder="Enter promo code"
          />
          <ErrorMessage
            name="promoCode"
            component="div"
            className="text-danger small mt-1"
          />
        </div>
      </div>

      <div className="form-check mb-3">
        <input
          type="checkbox"
          className="form-check-input"
          id="invoiceAddressChecked"
          name="invoiceAddressChecked"
          checked={values.invoiceAddressChecked}
          onChange={handleInvoiceToggle}
        />
        <label className="form-check-label" htmlFor="invoiceAddressChecked">
          Invoice Address
        </label>
      </div>

      {values.invoiceAddressChecked && (
        <div className="mb-3">
          <label htmlFor="invoiceAddress" className="form-label">
            Invoice Address
          </label>
          <Field
            as="textarea"
            id="invoiceAddress"
            name="invoiceAddress"
            className="form-control"
            rows="3"
          />
          <ErrorMessage
            name="invoiceAddress"
            component="div"
            className="text-danger small mt-1"
          />
        </div>
      )}
    </>
  );
};

// Wrap components with HOC
const PersonalDetailsSection = withFormSection(PersonalDetails, "Personal Details");
const TicketSelectionSection = withFormSection(TicketSelection, "Ticket Selection");
const SessionPreferencesSection = withFormSection(SessionPreferences, "Session Preferences");
const PaymentDetailsSection = withFormSection(PaymentDetails, "Payment Details");

// ----- Confirmation Page -----
const Confirmation = ({ data }) => (
  <div className="container mt-5">
    <h3>Registration Confirmation</h3>
    <p>Thank you for registering! Here are your registration details:</p>
    <ul className="list-group">
      <li className="list-group-item">
        <strong>Name:</strong> {data.name}
      </li>
      <li className="list-group-item">
        <strong>Email:</strong> {data.email}
      </li>
      <li className="list-group-item">
        <strong>Phone:</strong> {data.phone}
      </li>
      <li className="list-group-item">
        <strong>Organization:</strong> {data.organization}
      </li>
      <li className="list-group-item">
        <strong>Ticket Type:</strong> {data.ticketType}
      </li>
      <li className="list-group-item">
        <strong>Quantity:</strong> {data.quantity}
      </li>
      <li className="list-group-item">
        <strong>Sessions:</strong> {data.sessions.join(", ")}
      </li>
      <li className="list-group-item">
        <strong>Payment Method:</strong> {data.paymentMethod}
      </li>
      {data.promoCode && (
        <li className="list-group-item">
          <strong>Promo Code:</strong> {data.promoCode}
        </li>
      )}
      {data.invoiceAddressChecked && (
        <li className="list-group-item">
          <strong>Invoice Address:</strong> {data.invoiceAddress}
        </li>
      )}
    </ul>
  </div>
);

// ----- Main Event Registration Component -----
export default function EventRegistration() {
  const [submittedData, setSubmittedData] = useState(null);

  const initialValues = {
    name: "",
    email: "",
    phone: "",
    organization: "",
    ticketType: "Regular",
    quantity: 1,
    sessions: [],
    paymentMethod: "",
    promoCode: "",
    invoiceAddressChecked: false,
    invoiceAddress: "",
  };

  if (submittedData) {
    return <Confirmation data={submittedData} />;
  }

  return (
    <div className="container mt-5">
      <h2 className="mb-4 text-center">Online Event Registration</h2>

      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={(values) => {
          setSubmittedData(values);
        }}
      >
        {({ values, setFieldValue }) => (
          <Form>
            <PersonalDetailsSection />
            <TicketSelectionSection />
            <SessionPreferencesSection values={values} setFieldValue={setFieldValue} />
            <PaymentDetailsSection values={values} setFieldValue={setFieldValue} />

            <div className="d-flex justify-content-center mt-4">
              <button type="submit" className="btn btn-primary px-5">
                Register
              </button>
            </div>
          </Form>
        )}
      </Formik>
    </div>
  );
}
