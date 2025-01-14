import Box from "../components/home/Box";
import Footer from "../components/home/Footer";
import Header from "../components/home/Header";

export default function Home() {
    return (
        <div className="p-5 sm:p-6 md:px-10 lg:px-14 2xl:px-44 bg-[#f7f7f7] min-h-screen">
            <Header />

            <Box/>

            <Footer/>
        </div>
    )
}