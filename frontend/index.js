function getCategory(){
    const userData = JSON.parse(localStorage.getItem('userCredentials'))

    const category = document.getElementById('categoryText').value
    // let options = {
    //     method: 'GET',
    //     headers: {
    //         'Content-Type': 'application/json'
    //     },
    //     body: JSON.stringify({userName:userData.username,password:userData.password})
    // }
    var token = ''
    fetch(`http://localhost:8080/category?category=${category}`,{
        headers : {Authorization : 'Bearer '+ token}
    })
    .then(response => response.text())
    .then((res) => {
        console.log(res)
    })
}

function login() {
    const username = document.getElementById('userName').value;
    const password = document.getElementById('userPassword').value;
    
    let options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ userName: username, password: password })
    };
    
    fetch('http://localhost:8080/login', options)
        .then((response) => {
            // Check the response status here
            if (response.status === 200) {
                console.log('Login successful');
                
                document.getElementById('responseMessage').innerHTML = "Login Successful";
                localStorage.setItem('userCredentials', JSON.stringify({ username, password }));
               // response.text();
                console.log(response.text())
              //  localStorage.setItem('token',response)
                    window.location = "main.html";
                //return response.json(); // Assuming the response is JSON
            } else {
                console.log('Invalid credentials');
                document.getElementById('responseMessage').innerHTML = "Invalid Credentials!";
                throw new Error('Login failed'); // Stops further processing
            }
        })
        .then((user) =>{
            console.log(user.address)
            //localStorage.setItem('token',promiseResult)
            // This will only run if the status is 200
            
        })
}
