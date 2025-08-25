import React from "react";
import { usePowerCut } from "../context/PowerCutContext";

function AnnouncementList() {
  const { announcements } = usePowerCut();

  return (
    <div>
      <h5>Power Cut Announcements</h5>
      <div style={{ maxHeight: "300px", overflowY: "auto" }}>
        {announcements.map((ann) => (
          <div key={ann.id} className="border p-2 rounded mb-2">
            <strong>Street:</strong> {ann.street} <br />
            <strong>Message:</strong> {ann.message} <br />
            <strong>Time:</strong> {ann.time}
          </div>
        ))}
      </div>
    </div>
  );
}

export default AnnouncementList;
