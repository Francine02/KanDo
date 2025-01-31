import { UserTypes } from "../../types/UserTypes";

export default function AvatarImage({ image }: UserTypes) {
    return (
        <>
            <img
                className="w-8 h-8 md:w-11 md:h-11 border-2 border-[#ec8897] rounded-full"
                src={image}
                alt="Imagem de perfil" />
        </>
    )
}