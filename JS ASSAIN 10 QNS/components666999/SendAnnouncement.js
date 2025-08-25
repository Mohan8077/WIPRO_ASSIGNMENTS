import React, { useState } from "react";
import { usePowerCut } from "../context/PowerCutContext";

function SendAnnouncement() {
  const { addAnnouncement } = usePowerCut();
  const [street, setStreet] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (street.trim() && message.trim()) {
      addAnnouncement(street, message);
      setStreet("");
      setMessage("");
    } else {
      alert("Please fill out both fields");
    }
  };

  return (
    <div className="mb-4">
      <h5>Street Power Cut Announcements</h5>
      <form onSubmit={handleSubmit}>
        <div className="mb-2">
          <label>Street Name:</label>
          <input
            type="text"
            className="form-control"
            value={street}
            onChange={(e) => setStreet(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label>Message:</label>
          <textarea
            className="form-control"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
          ></textarea>
        </div>
        <button type="submit" className="btn btn-primary">Send Announcement</button>
      </form>
    </div>
  );
}

export default SendAnnouncement;
