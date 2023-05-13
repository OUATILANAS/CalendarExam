import React, { useState, useEffect } from 'react';

import Fullcalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
import frLocale from '@fullcalendar/core/locales/fr';

function HomePage() {
  const [showForm, setShowForm] = useState(false);
  const [events, setEvents] = useState([]);

useEffect(() => {
  async function fetchEvents() {
    try {
      const response = await fetch("/api/calendars/all");
      if (response.ok) {
        const data = await response.json();
        setEvents(
          data.map((event) => ({
            id: event.id,
            title: event.exam_name,
            start: event.start_time,
            end: event.end_time,
          }))
        );
      } else {
        console.error("Failed to fetch events");
      }
    } catch (error) {
      console.error(error);
    }
  }
  fetchEvents();
}, []);


const handleFormSubmit = async (event) => {
  event.preventDefault();
  const formData = new FormData(event.target);
  const newEvent = {
    exam_name: formData.get("exam_name"),
    start_time: formData.get("start_time"),
    end_time: formData.get("end_time"),
  };
  try {
    const response = await fetch("/api/calendars/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newEvent),
    });
    if (response.ok) {
      const savedEvent = await response.json();
      setEvents([...events, {
        id: savedEvent.id,
        title: savedEvent.exam_name,
        start: savedEvent.start_time,
        end: savedEvent.end_time,
      }]);
    } else {
      console.error("Failed to save event");
    }
  } catch (error) {
    console.error(error);
  }
  setShowForm(false);
};


  return (
    <div>
      <button onClick={() => setShowForm(true)}>Add Event</button>
      {showForm && (
        <form onSubmit={handleFormSubmit}>
          <label>
            Name Of Exam:
            <input type="text" name="exam_name" required />
          </label>
          
          <label>
            Start Date:
            <input type="datetime-local" name="start_time" required />
          </label>
          <label>
            End Date:
            <input type="datetime-local" name="end_time" required />
          </label>
          <button type="submit">Add Exam to Calendar</button>
        </form>
      )}
      <Fullcalendar
        plugins={[dayGridPlugin, timeGridPlugin, interactionPlugin]}
        initialView={"dayGridMonth"}
        headerToolbar={{
          start: "today prev,next", // will normally be on the left. if RTL, will be on the right
          center: "title",
          end: "dayGridMonth,timeGridWeek,timeGridDay", // will normally be on the right. if RTL, will be on the left
        }}
        height={"90vh"}
        events={events.map((event) => ({
          title: event.title,
          start: event.start,
          end: event.end,
          ...event.extendedProps,
        }))}
        locales={[ frLocale ]}
        locale='fr'
      />
    </div>
  );
}

export default HomePage;
