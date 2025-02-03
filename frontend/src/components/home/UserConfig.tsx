import { useState } from "react";
import { useAuth } from "../../hooks/useAuth";
import UserMenu from "./UserMenu";
import config from "../../assets/config.png";

export default function UserConfig() {
    const { user } = useAuth();
    const [menuOpen, setMenuOpen] = useState<boolean>(false);

    const toggleMenu = () => {
        setMenuOpen(!menuOpen);
    }

    return (
        <div className="flex items-center gap-2">
            <button onClick={toggleMenu} className="w-7 md:w-8">
                <img src={config} alt="Configurações" />
            </button>
            {(user && menuOpen) && <UserMenu name={user.name} email={user.email} />}
        </div>
    )
}