import { useState } from "react";
import Loading from "./Loading";

export default function Button() {
    const [loading, setLoading] = useState(false);

    const handleSocialAccount = () => {
        setLoading(!loading);
    }

    return (
        <button
            onClick={handleSocialAccount}
            className="bg-[#eb97a4] border border-gray-300 hover:opacity-90 active:bg-[#eb97a4] text-md rounded-full w-56 p-1.5 gap-3 mb-8 flex justify-center items-center">

            {loading ? (
                <Loading />
            ) : (
                <>
                    <div className="rounded-full p-1 bg-gray-100">
                        <img
                            className="w-8"
                            src="https://img.icons8.com/?size=100&id=V5cGWnc9R4xj&format=png&color=000000"
                            alt="Entrar com a sua conta do Google" />
                    </div>
                    <p className="text-sm 2xl:text-base text-white font-medium">Entre com o Google</p>
                </>
            )}
        </button>
    )
}