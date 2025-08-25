import React, { useState } from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import 'bootstrap/dist/css/bootstrap.min.css';

const ChessTournamentForm = () => {
  const [submissions, setSubmissions] = useState([]);

  // ✅ Validation Schema
  const validationSchema = Yup.object().shape({
    playerName: Yup.string()
      .min(3, 'Must be at least 3 characters')
      .required('Required'),

    dob: Yup.date()
      .required('Required')
      .test('age', 'Age must be between 5 and 90', function (value) {
        const today = new Date();
        const dob = new Date(value);
        const age = today.getFullYear() - dob.getFullYear();
        return age >= 5 && age <= 90;
      }),

    gender: Yup.string().required('Required'),

    fideId: Yup.string()
      .matches(/^\d{8}$/, 'FIDE ID must be exactly 8 digits')
      .required('Required'),

    rating: Yup.number()
      .min(100, 'Minimum rating is 100')
      .max(3000, 'Maximum rating is 3000')
      .required('Required'),

    email: Yup.string().email('Invalid email').required('Required'),

    mobile: Yup.string()
      .matches(/^[6-9]\d{9}$/, 'Invalid mobile number')
      .required('Required'),

    country: Yup.string().required('Required'),

    category: Yup.string().required('Required'),

    // ✅ Fixed conditional validation
    parentContact: Yup.string().when('category', {
      is: (val) => val === 'Under 12',
      then: () =>
        Yup.string()
          .matches(/^[6-9]\d{9}$/, 'Invalid parent contact')
          .required('Required'),
      otherwise: () => Yup.string().notRequired(),
    }),

    paymentConfirmed: Yup.boolean()
      .oneOf([true], 'Must be confirmed')
      .required(),

    terms: Yup.boolean()
      .oneOf([true], 'Must accept terms')
      .required(),
  });

  // Initial form values
  const initialValues = {
    playerName: '',
    dob: '',
    gender: '',
    fideId: '',
    rating: '',
    email: '',
    mobile: '',
    country: '',
    category: '',
    parentContact: '',
    paymentConfirmed: false,
    terms: false,
  };

  // Handle form submission
  const handleSubmit = (values, { resetForm }) => {
  console.log('📝 Chess Registration Data:', values);
  setSubmissions([...submissions, values]);
  resetForm();
};

  return (
    <div className="container mt-4">
      <h3 className="mb-4">Chess Tournament Registration Form</h3>

      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        {({ values }) => (
          <Form>
            <div className="row mb-3">
              <div className="col-md-6">
                <label>Player Name</label>
                <Field name="playerName" className="form-control" />
                <ErrorMessage name="playerName" className="text-danger" component="div" />
              </div>

              <div className="col-md-6">
                <label>Date of Birth</label>
                <Field type="date" name="dob" className="form-control" />
                <ErrorMessage name="dob" className="text-danger" component="div" />
              </div>
            </div>

            <div className="row mb-3">
              <div className="col-md-6">
                <label>Gender</label>
                <Field as="select" name="gender" className="form-control">
                  <option value="">Select</option>
                  <option>Male</option>
                  <option>Female</option>
                  <option>Other</option>
                </Field>
                <ErrorMessage name="gender" className="text-danger" component="div" />
              </div>

              <div className="col-md-6">
                <label>FIDE ID</label>
                <Field name="fideId" className="form-control" />
                <ErrorMessage name="fideId" className="text-danger" component="div" />
              </div>
            </div>

            <div className="row mb-3">
              <div className="col-md-6">
                <label>Rating</label>
                <Field name="rating" type="number" className="form-control" />
                <ErrorMessage name="rating" className="text-danger" component="div" />
              </div>

              <div className="col-md-6">
                <label>Email</label>
                <Field name="email" className="form-control" />
                <ErrorMessage name="email" className="text-danger" component="div" />
              </div>
            </div>

            <div className="row mb-3">
              <div className="col-md-6">
                <label>Mobile</label>
                <Field name="mobile" className="form-control" />
                <ErrorMessage name="mobile" className="text-danger" component="div" />
              </div>

              <div className="col-md-6">
                <label>Country</label>
                <Field name="country" className="form-control" />
                <ErrorMessage name="country" className="text-danger" component="div" />
              </div>
            </div>

            <div className="row mb-3">
              <div className="col-md-6">
                <label>Category</label>
                <Field as="select" name="category" className="form-control">
                  <option value="">Select</option>
                  <option value="Under 12">Under 12</option>
                  <option value="Under 18">Under 18</option>
                  <option value="Open">Open</option>
                </Field>
                <ErrorMessage name="category" className="text-danger" component="div" />
              </div>

              {values.category === 'Under 12' && (
                <div className="col-md-6">
                  <label>Parent Contact</label>
                  <Field name="parentContact" className="form-control" />
                  <ErrorMessage name="parentContact" className="text-danger" component="div" />
                </div>
              )}
            </div>

            <div className="form-check mb-2">
              <Field type="checkbox" name="paymentConfirmed" className="form-check-input" />
              <label className="form-check-label">Payment Confirmed</label>
              <ErrorMessage name="paymentConfirmed" className="text-danger" component="div" />
            </div>

            <div className="form-check mb-3">
              <Field type="checkbox" name="terms" className="form-check-input" />
              <label className="form-check-label">I accept Terms & Conditions</label>
              <ErrorMessage name="terms" className="text-danger" component="div" />
            </div>

            <button type="submit" className="btn btn-primary">Register Player</button>
          </Form>
        )}
      </Formik>

      {/* Submitted Players Table */}
      {submissions.length > 0 && (
        <div className="mt-5">
          <h4>Registered Players</h4>
          <table className="table table-bordered table-striped">
            <thead className="table-dark">
              <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>FIDE ID</th>
                <th>Rating</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Country</th>
                <th>Category</th>
                <th>Parent Contact</th>
                <th>Payment</th>
                <th>Terms</th>
              </tr>
            </thead>
            <tbody>
              {submissions.map((entry, index) => (
                <tr key={index}>
                  <td>{entry.playerName}</td>
                  <td>{entry.dob}</td>
                  <td>{entry.gender}</td>
                  <td>{entry.fideId}</td>
                  <td>{entry.rating}</td>
                  <td>{entry.email}</td>
                  <td>{entry.mobile}</td>
                  <td>{entry.country}</td>
                  <td>{entry.category}</td>
                  <td>{entry.parentContact ? entry.parentContact : '-'}</td>
                  <td>{entry.paymentConfirmed ? 'Yes' : 'No'}</td>
                  <td>{entry.terms ? 'Yes' : 'No'}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default ChessTournamentForm;
