import { useEffect, useState } from "react";
import { UserTypes } from "../types/UserTypes";
import { userInfo } from "../services/user";

export function useAuth() {
    const [user, setUser] = useState<UserTypes>();

    useEffect(() => {
        const getUserInfo = async () => {
            const data = await userInfo();
            if (data) {
                setUser(data);
            }
        }

        getUserInfo();
    }, [])

    return { user };
}