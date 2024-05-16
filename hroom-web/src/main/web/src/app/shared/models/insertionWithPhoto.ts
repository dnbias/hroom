import{Tag} from "./tags";

export class insertionWithPhoto {
  insertion_type!: string;
  id!: number;
  landlordId!: number;
  name!: string;
  tags!: Tag[];
  description!: string[];
  price!: number;
  city!: string;
  address!: string;
  area!: number;
  photoIds!: number[];
  photo!: any;
  rating!: number;
  receivedFeedbacksIds!: number[];
  availabilityId!: number;
}
