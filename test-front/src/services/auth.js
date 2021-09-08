import AppAxios from '../api/AppAxios';
import jwt_decode from 'jwt-decode';

export const login = async function(username, password) {
    const cred = {
        username: username, 
        password: password
    }

    try {
        const ret = await AppAxios.post('korisnici/auth', cred);
        const decoded = jwt_decode(ret.data);
        console.log(decoded);
        console.log(decoded.role.authority)
        window.localStorage.setItem('role', decoded.role.authority);
        window.localStorage.setItem('jwt', ret.data);
        window.localStorage.setItem('username', decoded.sub);
        console.log(window.localStorage['user']);
    } catch (error) {
        console.log(error);
        alert("Nesto je poslo po zlu!")
    }
    window.location.reload();
}

export const logout = function() {
    window.localStorage.removeItem('jwt');
    window.localStorage.removeItem('role');
    window.localStorage.removeItem('username');
    window.location.reload();
}