// HockeyRegistrationForm.js

import React, { useState } from "react";
import { Formik, Form, Field, FieldArray, ErrorMessage } from "formik";
import * as Yup from "yup";
import { Table, Button, Form as BootstrapForm, Col, Row } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

// Helper: Check age from date of birth
const getAge = (dob) => {
  const birthDate = new Date(dob);
  const today = new Date();
  let age = today.getFullYear() - birthDate.getFullYear();
  const m = today.getMonth() - birthDate.getMonth();
  if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) age--;
  return age;
};

const positionOptions = ["Forward", "Defense", "Goalie"];
const stickHandOptions = ["Left", "Right"];
const leagueLevelOptions = ["Amateur", "College", "Pro"];

const validationSchema = Yup.object({
  playerName: Yup.string()
    .required("Player name is required")
    .matches(/^[A-Za-z ]+$/, "Only alphabets and spaces are allowed")
    .min(3, "Must be at least 3 characters")
    .max(40, "Must be at most 40 characters"),
  jerseyNumber: Yup.number()
    .required("Jersey number is required")
    .integer("Must be an integer")
    .min(1, "Minimum 1")
    .max(99, "Maximum 99"),
  position: Yup.string()
    .required("Position is required")
    .oneOf(positionOptions),
  stickHand: Yup.string()
    .required("Stick hand is required")
    .oneOf(stickHandOptions),
  dateOfBirth: Yup.date()
    .required("Date of birth is required")
    .test(
      "age-range",
      "Age must be between 10 and 55",
      (value) => {
        if (!value) return false;
        const age = getAge(value);
        return age >= 10 && age <= 55;
      }
    ),
  nationality: Yup.string().required("Nationality is required"),
  email: Yup.string()
    .required("Email is required")
    .email("Invalid email format"),
  phone: Yup.string()
    .required("Phone is required")
    .matches(/^[6-9]\d{9}$/, "Invalid Indian mobile number"),
  playerId: Yup.string()
    .required("Player ID is required")
    .matches(/^HOCK-\d{4}$/, "Player ID format HOCK-XXXX"),
  guardianName: Yup.string().when("dateOfBirth", (dob, schema) => {
  return dob && getAge(dob) < 18
    ? schema.required("Guardian name is required")
    : schema.notRequired();
}),

  teamName: Yup.string().required("Team name is required"),
  leagueLevel: Yup.string()
    .required("League level is required")
    .oneOf(leagueLevelOptions),
  tournamentName: Yup.string().required("Tournament name is required"),
  startDate: Yup.date()
    .required("Start date is required"),
  endDate: Yup.date()
    .required("End date is required")
    .min(Yup.ref("startDate"), "End date must be on or after start date"),
  jerseySize: Yup.string().when("position", (pos, schema) => {
  return pos !== "Goalie"
    ? schema.required("Jersey size is required")
    : schema.notRequired();
}),

padSize: Yup.string().when("position", (pos, schema) => {
  return pos === "Goalie"
    ? schema.required("Pad size is required")
    : schema.notRequired();
}),

  hasMedicalCondition: Yup.boolean(),

medicalCertNumber: Yup.string().when("hasMedicalCondition", (hasCondition, schema) => {
  return hasCondition
    ? schema
        .required("Medical certificate number is required")
        .matches(/^MED-\d{4}$/, "Medical certificate format MED-XXXX")
    : schema.notRequired();
}),
  consent: Yup.boolean().oneOf([true], "Consent is required"),
  pastTeams: Yup.array()
    .of(
      Yup.object({
        clubName: Yup.string()
          .required("Club name is required")
          .min(2, "Minimum 2 characters")
          .max(30, "Maximum 30 characters"),
        years: Yup.number()
          .required("Years is required")
          .integer("Must be integer")
          .min(1, "Minimum 1 year")
          .max(20, "Maximum 20 years"),
      })
    )
    .max(3, "Maximum 3 past teams"),
});

const initialValues = {
  playerName: "",
  jerseyNumber: "",
  position: "",
  stickHand: "",
  dateOfBirth: "",
  nationality: "",
  email: "",
  phone: "",
  playerId: "",
  guardianName: "",
  teamName: "",
  leagueLevel: "",
  tournamentName: "",
  startDate: "",
  endDate: "",
  jerseySize: "",
  padSize: "",
  hasMedicalCondition: false,
  medicalCertNumber: "",
  consent: false,
  pastTeams: [],
};

const HockeyRegistrationForm = () => {
  const [records, setRecords] = useState([]);

  return (
    <div className="container my-4">
      <h2>Hockey Tournament Registration</h2>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={(values, { resetForm }) => {
          console.log(values);
          setRecords((prev) => [...prev, values]);
          resetForm();
        }}
      >
        {({ values, errors, touched, isValid, dirty }) => (
          <Form noValidate>
            <h4>Player Details</h4>
            <Row>
              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Player Name</BootstrapForm.Label>
                  <Field
                    name="playerName"
                    type="text"
                    className={`form-control ${
                      touched.playerName && errors.playerName ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="playerName"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Jersey Number</BootstrapForm.Label>
                  <Field
                    name="jerseyNumber"
                    type="number"
                    className={`form-control ${
                      touched.jerseyNumber && errors.jerseyNumber ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="jerseyNumber"
                  />
                </BootstrapForm.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Position</BootstrapForm.Label>
                  <Field
                    as="select"
                    name="position"
                    className={`form-select ${
                      touched.position && errors.position ? "is-invalid" : ""
                    }`}
                  >
                    <option value="">Select Position</option>
                    {positionOptions.map((pos) => (
                      <option key={pos} value={pos}>
                        {pos}
                      </option>
                    ))}
                  </Field>
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="position"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Stick Hand</BootstrapForm.Label>
                  <Field
                    as="select"
                    name="stickHand"
                    className={`form-select ${
                      touched.stickHand && errors.stickHand ? "is-invalid" : ""
                    }`}
                  >
                    <option value="">Select Stick Hand</option>
                    {stickHandOptions.map((hand) => (
                      <option key={hand} value={hand}>
                        {hand}
                      </option>
                    ))}
                  </Field>
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="stickHand"
                  />
                </BootstrapForm.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Date of Birth</BootstrapForm.Label>
                  <Field
                    name="dateOfBirth"
                    type="date"
                    className={`form-control ${
                      touched.dateOfBirth && errors.dateOfBirth ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="dateOfBirth"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Nationality</BootstrapForm.Label>
                  <Field
                    name="nationality"
                    type="text"
                    className={`form-control ${
                      touched.nationality && errors.nationality ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="nationality"
                  />
                </BootstrapForm.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Email</BootstrapForm.Label>
                  <Field
                    name="email"
                    type="email"
                    className={`form-control ${
                      touched.email && errors.email ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="email"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Phone</BootstrapForm.Label>
                  <Field
                    name="phone"
                    type="text"
                    className={`form-control ${
                      touched.phone && errors.phone ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="phone"
                  />
                </BootstrapForm.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Player ID</BootstrapForm.Label>
                  <Field
                    name="playerId"
                    type="text"
                    className={`form-control ${
                      touched.playerId && errors.playerId ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="playerId"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Guardian Name</BootstrapForm.Label>
                  <Field
                    name="guardianName"
                    type="text"
                    className={`form-control ${
                      touched.guardianName && errors.guardianName ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="guardianName"
                  />
                </BootstrapForm.Group>
              </Col>
            </Row>

            <h4>Team & Event Information</h4>

            <Row>
              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Team Name</BootstrapForm.Label>
                  <Field
                    name="teamName"
                    type="text"
                    className={`form-control ${
                      touched.teamName && errors.teamName ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="teamName"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>League Level</BootstrapForm.Label>
                  <Field
                    as="select"
                    name="leagueLevel"
                    className={`form-select ${
                      touched.leagueLevel && errors.leagueLevel ? "is-invalid" : ""
                    }`}
                  >
                    <option value="">Select League Level</option>
                    {leagueLevelOptions.map((lvl) => (
                      <option key={lvl} value={lvl}>
                        {lvl}
                      </option>
                    ))}
                  </Field>
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="leagueLevel"
                  />
                </BootstrapForm.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Tournament Name</BootstrapForm.Label>
                  <Field
                    name="tournamentName"
                    type="text"
                    className={`form-control ${
                      touched.tournamentName && errors.tournamentName ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="tournamentName"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={3}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>Start Date</BootstrapForm.Label>
                  <Field
                    name="startDate"
                    type="date"
                    className={`form-control ${
                      touched.startDate && errors.startDate ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="startDate"
                  />
                </BootstrapForm.Group>
              </Col>

              <Col md={3}>
                <BootstrapForm.Group className="mb-3">
                  <BootstrapForm.Label>End Date</BootstrapForm.Label>
                  <Field
                    name="endDate"
                    type="date"
                    className={`form-control ${
                      touched.endDate && errors.endDate ? "is-invalid" : ""
                    }`}
                  />
                  <ErrorMessage
                    component="div"
                    className="invalid-feedback"
                    name="endDate"
                  />
                </BootstrapForm.Group>
              </Col>
            </Row>

            {/* Conditional fields for jerseySize and padSize */}
            {values.position !== "Goalie" && (
              <BootstrapForm.Group className="mb-3">
                <BootstrapForm.Label>Jersey Size</BootstrapForm.Label>
                <Field
                  name="jerseySize"
                  type="text"
                  className={`form-control ${
                    touched.jerseySize && errors.jerseySize ? "is-invalid" : ""
                  }`}
                />
                <ErrorMessage
                  component="div"
                  className="invalid-feedback"
                  name="jerseySize"
                />
              </BootstrapForm.Group>
            )}

            {values.position === "Goalie" && (
              <BootstrapForm.Group className="mb-3">
                <BootstrapForm.Label>Pad Size</BootstrapForm.Label>
                <Field
                  name="padSize"
                  type="text"
                  className={`form-control ${
                    touched.padSize && errors.padSize ? "is-invalid" : ""
                  }`}
                />
                <ErrorMessage
                  component="div"
                  className="invalid-feedback"
                  name="padSize"
                />
              </BootstrapForm.Group>
            )}

            <h4>Medical & Consent</h4>

            <BootstrapForm.Group className="mb-3">
              <BootstrapForm.Check
                type="checkbox"
                label="Has Medical Condition"
                name="hasMedicalCondition"
                as={Field}
              />
            </BootstrapForm.Group>

            {values.hasMedicalCondition && (
              <BootstrapForm.Group className="mb-3">
                <BootstrapForm.Label>Medical Certificate Number</BootstrapForm.Label>
                <Field
                  name="medicalCertNumber"
                  type="text"
                  className={`form-control ${
                    touched.medicalCertNumber && errors.medicalCertNumber ? "is-invalid" : ""
                  }`}
                />
                <ErrorMessage
                  component="div"
                  className="invalid-feedback"
                  name="medicalCertNumber"
                />
              </BootstrapForm.Group>
            )}

            <BootstrapForm.Group className="mb-3">
              <BootstrapForm.Check
                type="checkbox"
                label="Consent"
                name="consent"
                as={Field}
              />
              <ErrorMessage
                component="div"
                className="text-danger"
                name="consent"
              />
            </BootstrapForm.Group>

            <h4>Past Teams</h4>

            <FieldArray name="pastTeams">
              {({ push, remove, form }) => (
                <div>
                  {form.values.pastTeams.map((_, index) => (
                    <Row key={index} className="mb-3">
                      <Col md={6}>
                        <BootstrapForm.Group>
                          <BootstrapForm.Label>Club Name</BootstrapForm.Label>
                          <Field
                            name={`pastTeams.${index}.clubName`}
                            type="text"
                            className={`form-control ${
                              form.touched.pastTeams &&
                              form.touched.pastTeams[index] &&
                              form.touched.pastTeams[index].clubName &&
                              form.errors.pastTeams &&
                              form.errors.pastTeams[index] &&
                              form.errors.pastTeams[index].clubName
                                ? "is-invalid"
                                : ""
                            }`}
                          />
                          <ErrorMessage
                            component="div"
                            className="invalid-feedback"
                            name={`pastTeams.${index}.clubName`}
                          />
                        </BootstrapForm.Group>
                      </Col>

                      <Col md={4}>
                        <BootstrapForm.Group>
                          <BootstrapForm.Label>Years</BootstrapForm.Label>
                          <Field
                            name={`pastTeams.${index}.years`}
                            type="number"
                            className={`form-control ${
                              form.touched.pastTeams &&
                              form.touched.pastTeams[index] &&
                              form.touched.pastTeams[index].years &&
                              form.errors.pastTeams &&
                              form.errors.pastTeams[index] &&
                              form.errors.pastTeams[index].years
                                ? "is-invalid"
                                : ""
                            }`}
                          />
                          <ErrorMessage
                            component="div"
                            className="invalid-feedback"
                            name={`pastTeams.${index}.years`}
                          />
                        </BootstrapForm.Group>
                      </Col>

                      <Col md={2} className="d-flex align-items-center">
                        <Button
                          variant="danger"
                          onClick={() => remove(index)}
                        >
                          Remove
                        </Button>
                      </Col>
                    </Row>
                  ))}

                  {form.values.pastTeams.length < 3 && (
                    <Button
                      type="button"
                      onClick={() => push({ clubName: "", years: "" })}
                    >
                      + Add Past Team
                    </Button>
                  )}
                </div>
              )}
            </FieldArray>

            <div className="mt-4">
              <Button
                variant="primary"
                type="submit"
                disabled={!(isValid && dirty)}
              >
                Submit
              </Button>
              <Button
                variant="secondary"
                type="reset"
                className="ms-2"
              >
                Reset
              </Button>
            </div>
          </Form>
        )}
      </Formik>

      {/* Table to show records */}
      {records.length > 0 && (
        <div className="mt-5">
          <h4>Submitted Records</h4>
          <Table bordered hover responsive>
            <thead>
              <tr>
                <th>Player Name</th>
                <th>Jersey Number</th>
                <th>Position</th>
                <th>Stick Hand</th>
                <th>Date of Birth</th>
                <th>Nationality</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Player ID</th>
                <th>Guardian Name</th>
                <th>Team Name</th>
                <th>League Level</th>
                <th>Tournament Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Jersey Size</th>
                <th>Pad Size</th>
                <th>Has Medical Condition</th>
                <th>Medical Cert Number</th>
                <th>Consent</th>
                <th>Past Teams</th>
              </tr>
            </thead>
            <tbody>
              {records.map((rec, i) => (
                <tr key={i}>
                  <td>{rec.playerName}</td>
                  <td>{rec.jerseyNumber}</td>
                  <td>{rec.position}</td>
                  <td>{rec.stickHand}</td>
                  <td>{rec.dateOfBirth}</td>
                  <td>{rec.nationality}</td>
                  <td>{rec.email}</td>
                  <td>{rec.phone}</td>
                  <td>{rec.playerId}</td>
                  <td>{rec.guardianName || "-"}</td>
                  <td>{rec.teamName}</td>
                  <td>{rec.leagueLevel}</td>
                  <td>{rec.tournamentName}</td>
                  <td>{rec.startDate}</td>
                  <td>{rec.endDate}</td>
                  <td>{rec.jerseySize || "-"}</td>
                  <td>{rec.padSize || "-"}</td>
                  <td>{rec.hasMedicalCondition ? "Yes" : "No"}</td>
                  <td>{rec.medicalCertNumber || "-"}</td>
                  <td>{rec.consent ? "Yes" : "No"}</td>
                  <td>
                    {rec.pastTeams.length > 0
                      ? rec.pastTeams
                          .map((pt) => `${pt.clubName} (${pt.years} yrs)`)
                          .join(", ")
                      : "-"}
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
      )}
    </div>
  );
};

export default HockeyRegistrationForm;
