import AddCard from "./AddCard";
import Card from "./Card";
import TitleColumns from "./TitleColumns";

export default function Box() {
    return (
        <div className="grid md:grid-cols-3 gap-10 pb-20">
            <div>
                <TitleColumns title="Para fazer" quantity={1} />
                <AddCard/>
                <Card/>
                <Card/>
            </div>
            <div>
                <TitleColumns title="Fazendo" quantity={21} />
                <AddCard/>
                <Card/>
            </div>
            <div>
                <TitleColumns title="Pronta" quantity={16} />
                <AddCard/>
                <Card/>
                <Card/>
                <Card/>
            </div>
        </div>
    )
}