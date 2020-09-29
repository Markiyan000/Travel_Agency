let sendDeleteRequest = async (resource, id) => {
    const response = await fetch(`http://localhost:8080/${resource}/${id}`, {
        method: 'DELETE'
    });
    if(response.ok) {
        alert('Item with id ' + id + ' was deleted!');
    }
};