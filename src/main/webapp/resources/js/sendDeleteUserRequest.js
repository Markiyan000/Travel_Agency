let sendDeleteRequest = async (resource, id) => {
    await fetch(`http://localhost:8080/${resource}/${id}`, {
        method: 'DELETE'
    })
};