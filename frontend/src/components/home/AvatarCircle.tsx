import AvatarImage from "./AvatarImage";

export default function AvatarCircle() {
    return (
        <div className="flex -space-x-3 md:-space-x-4 rtl:space-x-reverse">
            <AvatarImage />
            <a className="flex items-center justify-center w-8 h-8 md:w-11 md:h-11 text-xs md:text-base font-medium text-white bg-[#ec8897] border-2 border-[#ec8897] rounded-full" href="#">+5</a>
        </div>
    )
}