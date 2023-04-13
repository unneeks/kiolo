import React from "react";

const TryoutUI = ({
  handleFileChange,
  handleOptionChange,
  handleTokenChange,
  handleClassify,
  handleSubmitForExtraction,
  classificationResult,
  extractionResult,
}) => {
  return (
    <div>
      <h2>Try It Out</h2>
      <form onSubmit={handleClassify}>
        <div>
          <label htmlFor="file">Select a file:</label>
          <input type="file" id="file" onChange={handleFileChange} />
        </div>
        <div>
          <label htmlFor="documentType">Document Type:</label>
          <select id="documentType" name="documentType" onChange={handleOptionChange}>
            <option value="">Select a document type</option>
            <option value="payslip">Payslip</option>
            <option value="statement">Statement</option>
            <option value="application">Application</option>
          </select>
        </div>
        <div>
          <label htmlFor="token">Token:</label>
          <input type="text" id="token" onChange={handleTokenChange} />
        </div>
        <div>
          <button type="submit">Classify Document</button>
        </div>
      </form>
      {classificationResult && (
        <div>
          <h3>Classification Result:</h3>
          <p>{classificationResult}</p>
          <button onClick={handleSubmitForExtraction}>Submit for Extraction</button>
        </div>
      )}
      {extractionResult && (
        <div>
          <h3>Extraction Result:</h3>
          <p>{extractionResult}</p>
        </div>
      )}
    </div>
  );
};

export default TryoutUI;
