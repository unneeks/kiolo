const classifyDocument = async (file, options, token) => {
  const url = "http://localhost:8080/api/classifydoc";
  const formData = new FormData();
  formData.append("file", file);
  if (options) {
    Object.keys(options).forEach((key) => {
      formData.append(key, options[key]);
    });
  }
  const response = await fetch(url, {
    method: "POST",
    body: formData,
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  const result = await response.json();
  return result;
};

export default classifyDocument;
