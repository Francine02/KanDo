import Logo from "./Logo"

export default function Title() {
    return (
        <div className="space-y-4">
            <Logo />
            <h3 className="font-medium text-lg sm:text-xl lg:text-2xl">KanDo</h3>
            <h1 className="font-black text-transparent bg-clip-text bg-gradient-to-r from-[#dcaeb5] via-[#ec8897] to-[#d8d298] text-3xl sm:text-4xl lg:text-6xl 2xl:text-7xl">
                Controle total sobre suas tarefas.
            </h1>
            <p className="text-sm sm:text-base lg:text-lg text-gray-800">
                Planeje, organize, realize. Tudo começa com seu login.
            </p>
        </div>
    )
}