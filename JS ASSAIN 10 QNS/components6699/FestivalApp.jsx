import React, { useState, useEffect } from "react";

const FestivalApp = () => {
  const [festival, setFestival] = useState("Diwali");
  const [countdown, setCountdown] = useState(5);

  // Q1: useEffect that runs every render (no dependency array)
  useEffect(() => {
    console.log("Festival App Rendered");
  });

  // Q2: Welcome alert on initial mount only
  useEffect(() => {
    alert("Welcome to Diwali Festival App");
  }, []);

  // Q3: Log whenever festival changes
  useEffect(() => {
    console.log(`Festival changed to ${festival}`);
  }, [festival]);

  // Q4: Countdown timer with cleanup
  useEffect(() => {
    const timerId = setInterval(() => {
      setCountdown((prev) => {
        if (prev <= 1) {
          clearInterval(timerId);
          return 0;
        }
        return prev - 1;
      });
    }, 1000);

    // Cleanup on unmount
    return () => {
      clearInterval(timerId);
      console.log("Timer cleared");
    };
  }, []);

  // Q5: Log if festival OR countdown changes
  useEffect(() => {
    console.log(`Festival: ${festival}, Countdown: ${countdown}`);
  }, [festival, countdown]);

  // For demonstration, change festival every 3 seconds through a sequence
  useEffect(() => {
    if (countdown === 0) {
      if (festival === "Diwali") setFestival("Holi");
      else if (festival === "Holi") setFestival("Pongal");
      else if (festival === "Pongal") setFestival("Diwali");
      setCountdown(5); // reset countdown on festival change
    }
  }, [countdown, festival]);

  return (
    <div style={{ textAlign: "center", marginTop: "30px" }}>
      <h1>{festival} Festival App</h1>
      <p>Countdown: {countdown} seconds</p>
    </div>
  );
};

export default FestivalApp;
