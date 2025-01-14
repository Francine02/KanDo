import AvatarCircle from "./AvatarCircle";
import ShareLink from "./ShareLink";

export default function Header() {
    return (
        <header className="flex justify-between items-center">
            <h1 className="font-black text-transparent bg-clip-text bg-gradient-to-r from-[#dcaeb5] via-[#ec8897] to-[#d8d298] text-2xl sm:text-3xl lg:text-4xl">
                KanDo
            </h1>

            <div className="flex space-x-5">
                <ShareLink />
                <AvatarCircle />
            </div>
        </header>
    )
}