
export default function Button() {
    return (
        <div className="flex items-center gap-2">
            <button className="w-8 h-8 md:w-10 md:h-10 border-2 border-dashed border-[#ec8897] rounded-full flex items-center justify-center p-2">
                <p className="text-3xl md:text-4xl font-bold text-[#b05b68] ">+</p>
            </button>
            <p className="text-xs md:text-sm text-[#b05b68]">Add membro</p>
        </div>
    )
}