let sendDeleteUserRequest = async (userId) => {
    console.log(userId);
    await fetch(`http://localhost:8080/users/${userId}`, {
        method: 'DELETE'
    })
};