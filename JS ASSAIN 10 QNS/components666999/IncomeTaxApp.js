import React from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

const NavigationBar = () => (
  <Navbar bg="light" expand="lg" collapseOnSelect>
    <Container>
      <Navbar.Brand>Income Tax Department</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="me-auto">
          <Nav.Link href="#home">Home</Nav.Link>
          <Nav.Link href="#add-taxpayer">Add Taxpayer</Nav.Link>
          <Nav.Link href="#taxpayer-list">Taxpayer List</Nav.Link>
          <Nav.Link href="#calculate-tax">Calculate Tax</Nav.Link>
          <Nav.Link href="#tax-rates">Tax Rates</Nav.Link>
          <Nav.Link href="#contact">Contact</Nav.Link>
          <Nav.Link href="#about">About</Nav.Link>
          <Nav.Link href="#faq">FAQ</Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Container>
  </Navbar>
);

const boxData = [
  {
    id: "home",
    title: "Home",
    content: "Welcome to the Income Tax Department Portal",
  },
  {
    id: "add-taxpayer",
    title: "Add Taxpayer",
    content: "Add Taxpayer Page",
  },
  {
    id: "taxpayer-list",
    title: "Taxpayer List",
    content: "Taxpayer List Page",
  },
  {
    id: "calculate-tax",
    title: "Calculate Tax",
    content: "Calculate Tax Page",
  },
  {
    id: "tax-rates",
    title: "Tax Rates",
    content: "Tax Rates Information",
  },
  {
    id: "contact",
    title: "Contact",
    content: "Contact the Income Tax Department",
  },
  {
    id: "about",
    title: "About",
    content: "About the Income Tax Department",
  },
  {
    id: "faq",
    title: "FAQ",
    content: "Frequently Asked Questions",
  },
  {
    id: "not-found",
    title: "Not Found",
    content: "404 – Page Not Found",
  },
];

const Box = ({ title, content }) => (
  <div
    style={{
      border: "1px solid #ddd",
      padding: "15px",
      borderRadius: "5px",
      boxShadow: "1px 1px 4px rgba(0,0,0,0.1)",
      backgroundColor: "white",
      marginBottom: "20px",
    }}
  >
    <h5>{title}</h5>
    <p>{content}</p>
  </div>
);

const IncomeTaxDashboard = () => {
  return (
    <>
      <NavigationBar />
      <Container
        style={{
          marginTop: "20px",
          display: "grid",
          gridTemplateColumns: "repeat(auto-fit, minmax(250px, 1fr))",
          gap: "20px",
        }}
      >
        {boxData.map(({ id, title, content }) => (
          <Box key={id} title={title} content={content} />
        ))}
      </Container>
    </>
  );
};

export default IncomeTaxDashboard;
