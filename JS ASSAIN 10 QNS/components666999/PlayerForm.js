import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

const PlayerSchema = Yup.object().shape({
  name: Yup.string().min(3, "Too Short!").required("Required"),
  age: Yup.number().min(16).max(40).required("Required"),
  position: Yup.string().oneOf(["Forward", "Midfielder", "Defender", "Goalkeeper"]).required("Required"),
  club: Yup.string().required("Required"),
  nationality: Yup.string().required("Required"),
  goals: Yup.number().min(0).required("Required"),
  matchesPlayed: Yup.number().min(0).required("Required"),
  jerseyNumber: Yup.number().min(1).max(99).required("Required"),
  email: Yup.string().email("Invalid email").required("Required"),
  contactNumber: Yup.string().matches(/^\d{10}$/, "Must be exactly 10 digits").required("Required"),
});

function PlayerForm({ initialValues, onSubmit }) {
  return (
    <Formik
      initialValues={initialValues}
      validationSchema={PlayerSchema}
      onSubmit={onSubmit}
      enableReinitialize
    >
      {({ isSubmitting }) => (
        <Form>
          <div>
            <label>Name:</label>
            <Field name="name" type="text" />
            <ErrorMessage name="name" component="div" className="text-danger" />
          </div>

          <div>
            <label>Age:</label>
            <Field name="age" type="number" />
            <ErrorMessage name="age" component="div" className="text-danger" />
          </div>

          <div>
            <label>Position:</label>
            <Field name="position" as="select">
              <option value="">Select Position</option>
              <option value="Forward">Forward</option>
              <option value="Midfielder">Midfielder</option>
              <option value="Defender">Defender</option>
              <option value="Goalkeeper">Goalkeeper</option>
            </Field>
            <ErrorMessage name="position" component="div" className="text-danger" />
          </div>

          <div>
            <label>Club:</label>
            <Field name="club" type="text" />
            <ErrorMessage name="club" component="div" className="text-danger" />
          </div>

          <div>
            <label>Nationality:</label>
            <Field name="nationality" type="text" />
            <ErrorMessage name="nationality" component="div" className="text-danger" />
          </div>

          <div>
            <label>Goals:</label>
            <Field name="goals" type="number" />
            <ErrorMessage name="goals" component="div" className="text-danger" />
          </div>

          <div>
            <label>Matches Played:</label>
            <Field name="matchesPlayed" type="number" />
            <ErrorMessage name="matchesPlayed" component="div" className="text-danger" />
          </div>

          <div>
            <label>Jersey Number:</label>
            <Field name="jerseyNumber" type="number" />
            <ErrorMessage name="jerseyNumber" component="div" className="text-danger" />
          </div>

          <div>
            <label>Email:</label>
            <Field name="email" type="email" />
            <ErrorMessage name="email" component="div" className="text-danger" />
          </div>

          <div>
            <label>Contact Number:</label>
            <Field name="contactNumber" type="text" />
            <ErrorMessage name="contactNumber" component="div" className="text-danger" />
          </div>

          <button type="submit" disabled={isSubmitting}>
            {initialValues.id ? "Update Player" : "Add Player"}
          </button>
        </Form>
      )}
    </Formik>
  );
}

export default PlayerForm;
