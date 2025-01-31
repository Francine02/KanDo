import { UserTypes } from "../../types/UserTypes";
import { UserOptions } from "./userOptions";

export default function UserMenu({ name, email }: UserTypes) {
    return (
        <div className=" top-16 md:top-20 right-5 md:right-10 lg:right-14 2xl:right-44 absolute bg-gray-200 divide-y divide-gray-300 rounded-lg">
            <div className="px-4 py-3 text-sm text-gray-900 ">
                <div>{name}</div>
                <div className="font-medium truncate">{email}</div>
            </div>
            <ul className="py-2 text-sm text-gray-700 " aria-labelledby="avatarButton">
                <UserOptions option="Deletar link" />
            </ul>
            <div className="py-1">
                <a href="http://localhost:8080/logout" className="block px-4 py-2 text-sm hover:bg-gray-300 ">Sair</a>
            </div>
        </div>
    )
}