import axios from 'axios';

export const userInfo = async () => {
    try {
        const response = await axios.get("http://localhost:8080/user", {
            withCredentials: true
        });

        return response.data;
    } catch (e) {
        console.log("Erro ao recuperar as informações do usuário!");
        return null;
    }
}