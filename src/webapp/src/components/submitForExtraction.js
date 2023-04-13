const submitForExtraction = async (file, token) => {
  const url = "http://localhost:8080/api/submitforextraction";
  const formData = new FormData();
  formData.append("file", file);
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

export default submitForExtraction;
