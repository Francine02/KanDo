export default function Footer() {
    return (
        <footer className="border-t-2 border-gray-200 pt-6">
            <div className="flex justify-between items-center">
                <h1 className="font-black text-transparent bg-clip-text bg-gradient-to-r from-[#dcaeb5] via-[#ec8897] to-[#d8d298] text-xl sm:text-2xl lg:text-3xl">
                    KanDo
                </h1>

                <div className="flex space-x-5 sm:space-x-8">
                    <a href="https://github.com/Francine02" target="_blank">
                        <img src="https://img.icons8.com/?size=100&id=12598&format=png&color=000000" alt="github" className="w-8 hover:opacity-80" />
                    </a>
                    <a href="https://www.linkedin.com/in/francine-ccruz/" target="_blank">
                        <img src="https://img.icons8.com/?size=100&id=8808&format=png&color=000000" alt="LinkedIn" className="w-8 hover:opacity-80" />
                    </a>
                    <a href="https://wa.me/5551986283397" target="_blank">
                        <img src="https://img.icons8.com/?size=100&id=16733&format=png&color=000000" alt="Whatsapp" className="w-8 hover:opacity-80" />
                    </a>
                </div>
            </div>
            <p className="text-sm font-medium pt-5">Desenvolvido com &#128150; por Francine Cruz.</p>
        </footer>
    )
}