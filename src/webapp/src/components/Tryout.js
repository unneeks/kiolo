import React, { useState } from "react";
import classifyDocument from "./classifyDocument";
import submitForExtraction from "./submitForExtraction";
import TryoutUI from "./TryoutUI";

const Tryout = () => {
  const [file, setFile] = useState(null);
  const [options, setOptions] = useState({});
  const [token, setToken] = useState("");
  const [classificationResult, setClassificationResult] = useState("");
  const [extractionResult, setExtractionResult] = useState("");
  const [jobId, setJobId] = useState(0);

  const handleFileChange = (event) => {
    setFile(event.target.files[0]);
  };

  const handleOptionChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setOptions((prevOptions) => ({
      ...prevOptions,
      [name]: value,
    }));
  };

  const handleTokenChange = (event) => {
    setToken(event.target.value);
  };

  const handleClassify = async (event) => {
    event.preventDefault();
    if (!file) {
      alert("Please select a file.");
      return;
    }
    try {
      const result = await classifyDocument(file, options, token);
      setClassificationResult(result.result);
      setJobId(result.id);
    } catch (error) {
      alert("Error classifying document.");
      console.log(error);
    }
  };

  const handleSubmitForExtraction = async (event) => {
    event.preventDefault();
    if (!jobId) {
      alert("Please classify a document first.");
      return;
    }
    try {
      const result = await submitForExtraction(jobId, token);
      setExtractionResult(result.status);
    } catch (error) {
      alert("Error submitting document for extraction.");
      console.log(error);
    }
  };

  return (
    <TryoutUI
      handleFileChange={handleFileChange}
      handleOptionChange={handleOptionChange}
      handleTokenChange={handleTokenChange}
      handleClassify={handleClassify}
      handleSubmitForExtraction={handleSubmitForExtraction}
      classificationResult={classificationResult}
      extractionResult={extractionResult}
    />
  );
};

export default Tryout;
